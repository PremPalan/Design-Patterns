package com.ram.Command.practice.RestaurantOrderManagementSystem.Commands;

import com.ram.Command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Reciever.BillingSystem;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Reciever.InventorySystem;
import com.ram.Command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class CancelOrderCommand extends Command {

    private final int orderId;
    private final RestaurantManagement orderManager;
    private final InventorySystem inventorySystem;
    private final BillingSystem billingSystem;

    public CancelOrderCommand(int orderId, RestaurantManagement orderManager, InventorySystem inventorySystem,
                              BillingSystem billingSystem) {
        super(null);
        this.orderId = orderId;
        this.orderManager = orderManager;
        this.inventorySystem = inventorySystem;
        this.billingSystem = billingSystem;
    }

    @Override
    public void execute() {

        Order order = orderManager.getOrderById(orderId);

        if (order != null) {
            order.setStatus(Status.CANCELLED);
            orderManager.updateOrder(order);
        }
    }
}