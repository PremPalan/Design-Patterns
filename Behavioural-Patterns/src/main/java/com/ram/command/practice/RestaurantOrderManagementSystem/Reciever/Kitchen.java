package com.ram.command.practice.RestaurantOrderManagementSystem.Reciever;

import com.ram.command.practice.RestaurantOrderManagementSystem.Commands.Status;
import com.ram.command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class Kitchen {
    public void notifyKitchen(Order order, RestaurantManagement orderManager) {
        order.setStatus(Status.READY);
//        orderManager.processNext();
    }
}
