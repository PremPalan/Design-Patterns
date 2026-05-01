package com.ram.command.practice.RestaurantOrderManagementSystem.Invoker;

import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.BurgerCommands.OrderBurgerCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.CancelOrderCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.CoffeeCommands.OrderCoffeeCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.CokeCommands.OrderCokeCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.Command;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.FriesCommands.OrderFriesCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.PastaCommands.OrderPastaCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.PizzaCommands.OrderPizzaCommand;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Burger;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Coffee;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Coke;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Fries;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Pasta;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Pizza;
import com.ram.command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;
import com.ram.command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class Waiter {

    private final RestaurantManagement orderManager;

    public Waiter(RestaurantManagement orderManager) {
        this.orderManager = orderManager;
    }

    public int placeOrder(Item item, int quantity, int tableNo) {

        int orderId = orderManager.generateNextOrderNo();

        Order order = new Order(orderId, item, quantity, tableNo);

        Command command;

        if (item instanceof Pizza) {

            command = new OrderPizzaCommand(
                    order,
                    orderManager,
                    orderManager.getInventorySystem(),
                    orderManager.getKitchen(),
                    orderManager.getBillingSystem()
            );

        } else if (item instanceof Pasta) {

            command = new OrderPastaCommand(
                    order,
                    orderManager,
                    orderManager.getInventorySystem(),
                    orderManager.getKitchen(),
                    orderManager.getBillingSystem()
            );

        } else if (item instanceof Burger) {

            command = new OrderBurgerCommand(
                    order,
                    orderManager,
                    orderManager.getInventorySystem(),
                    orderManager.getKitchen(),
                    orderManager.getBillingSystem()
            );

        } else if (item instanceof Fries) {

            command = new OrderFriesCommand(
                    order,
                    orderManager,
                    orderManager.getInventorySystem(),
                    orderManager.getKitchen(),
                    orderManager.getBillingSystem()
            );

        } else if (item instanceof Coke) {

            command = new OrderCokeCommand(
                    order,
                    orderManager,
                    orderManager.getInventorySystem(),
                    orderManager.getKitchen(),
                    orderManager.getBillingSystem()
            );

        } else if (item instanceof Coffee) {

            command = new OrderCoffeeCommand(
                    order,
                    orderManager,
                    orderManager.getInventorySystem(),
                    orderManager.getKitchen(),
                    orderManager.getBillingSystem()
            );

        } else {
            throw new IllegalArgumentException("Unsupported menu item");
        }

        orderManager.submit(command);

        return orderId;
    }

    public void cancelOrder(int orderId) {

        Command command = new CancelOrderCommand(
                orderId,
                orderManager,
                orderManager.getInventorySystem(),
                orderManager.getBillingSystem()
        );

        orderManager.submit(command);
    }
}