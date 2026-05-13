package com.ram.Command.practice.RestaurantOrderManagementSystem.Reciever;

import com.ram.Command.practice.RestaurantOrderManagementSystem.Commands.Status;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Order.Order;
import com.ram.Command.practice.RestaurantOrderManagementSystem.RestaurantManagement;

public class Kitchen {
    public void notifyKitchen(Order order, RestaurantManagement orderManager) {
        order.setStatus(Status.READY);
//        orderManager.processNext();
    }
}
