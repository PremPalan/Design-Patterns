package com.ram.Command.practice.RestaurantOrderManagementSystem.Commands;

import com.ram.Command.practice.RestaurantOrderManagementSystem.Order.Order;

public abstract class Command {

    protected Order order;

    public Command(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public abstract void execute();
}