package com.ram.command.practice.RestaurantOrderManagementSystem;

import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.Command;
import com.ram.command.practice.RestaurantOrderManagementSystem.Invoker.Waiter;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Burger;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Coke;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Pasta;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Pizza;
import com.ram.command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.command.practice.RestaurantOrderManagementSystem.Reciever.BillingSystem;
import com.ram.command.practice.RestaurantOrderManagementSystem.Reciever.InventorySystem;
import com.ram.command.practice.RestaurantOrderManagementSystem.Reciever.Kitchen;

import java.util.*;

public class RestaurantManagement {

    private final Queue<Command> queue = new LinkedList<>();
    private final Map<Integer, Order> orders = new HashMap<>();

    private final InventorySystem inventorySystem;
    private final Kitchen kitchen;
    private final BillingSystem billingSystem;

    private int nextOrderId = 1001;

    public RestaurantManagement(InventorySystem inventorySystem,
                                Kitchen kitchen,
                                BillingSystem billingSystem) {
        this.inventorySystem = inventorySystem;
        this.kitchen = kitchen;
        this.billingSystem = billingSystem;
    }

    public int generateNextOrderNo() {
        return nextOrderId++;
    }

    public void submit(Command command) {
        queue.offer(command);

        if (command.getOrder() != null) {
            orders.put(command.getOrder().getOrderId(), command.getOrder());
        }
    }

    public void processNext() {
        Command command = queue.poll();

        if (command != null) {
            command.execute();
        }
    }

    public void processAll() {
        while (!queue.isEmpty()) {
            processNext();
        }
    }

    public void updateOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public BillingSystem getBillingSystem() {
        return billingSystem;
    }

    public Order getOrderById(int orderId) {
        return orders.get(orderId);
    }

    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        BillingSystem billingSystem = new BillingSystem();
        InventorySystem inventorySystem = new InventorySystem();
        final RestaurantManagement orderManager = new RestaurantManagement(inventorySystem, kitchen, billingSystem);

        Waiter waiter = new Waiter(orderManager);

        Item pizza = new Pizza("Margherita");
        Item pasta = new Pasta("Agleo Oleo");
        Item burger = new Burger("Aloo Tikki");
        Item coke = new Coke("Diet Coke");

        waiter.placeOrder(pizza, 2, 1);
        waiter.placeOrder(pasta, 1,1);
        waiter.placeOrder(burger, 2, 2);
        waiter.placeOrder(coke, 2,2);

        orderManager.processNext();

        System.out.println("Total bill : " + billingSystem.getTotalBill(2));
    }
}