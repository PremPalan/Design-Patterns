package com.ram.Command.practice.RestaurantOrderManagementSystem.Commands.PizzaCommands;

import com.ram.Command.practice.RestaurantOrderManagementSystem.Commands.Command;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Commands.Status;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Reciever.BillingSystem;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Reciever.InventorySystem;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Reciever.Kitchen;
import com.ram.Command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class OrderPizzaCommand extends Command {

    private final RestaurantManagement orderManager;
    private final InventorySystem inventorySystem;
    private final Kitchen kitchen;
    private final BillingSystem billingSystem;

    public OrderPizzaCommand(Order order,
                             RestaurantManagement orderManager,
                             InventorySystem inventorySystem,
                             Kitchen kitchen,
                             BillingSystem billingSystem) {
        super(order);
        this.orderManager = orderManager;
        this.inventorySystem = inventorySystem;
        this.kitchen = kitchen;
        this.billingSystem = billingSystem;
    }

    @Override
    public void execute() {
        order.setStatus(Status.PREPARING);
        try {
            inventorySystem.reserveInventory(order,orderManager);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        kitchen.notifyKitchen(order, orderManager);
        billingSystem.addToBill(order, orderManager);
        orderManager.updateOrder(order);
    }
}