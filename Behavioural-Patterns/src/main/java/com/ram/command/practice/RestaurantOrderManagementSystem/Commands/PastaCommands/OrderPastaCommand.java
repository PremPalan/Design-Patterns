package com.ram.command.practice.RestaurantOrderManagementSystem.Commands.PastaCommands;

import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.Command;
import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.Status;
import com.ram.command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.command.practice.RestaurantOrderManagementSystem.Reciever.BillingSystem;
import com.ram.command.practice.RestaurantOrderManagementSystem.Reciever.InventorySystem;
import com.ram.command.practice.RestaurantOrderManagementSystem.Reciever.Kitchen;
import com.ram.command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class OrderPastaCommand extends Command {

    private final RestaurantManagement orderManager;
    private final InventorySystem inventorySystem;
    private final Kitchen kitchen;
    private final BillingSystem billingSystem;

    public OrderPastaCommand(Order order,
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
            inventorySystem.reserveInventory(order, orderManager);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        kitchen.notifyKitchen(order, orderManager);
        billingSystem.addToBill(order, orderManager);
        orderManager.updateOrder(order);
    }
}