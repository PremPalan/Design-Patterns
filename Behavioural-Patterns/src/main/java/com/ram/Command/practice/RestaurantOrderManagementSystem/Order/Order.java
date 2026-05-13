package com.ram.Command.practice.RestaurantOrderManagementSystem.Order;

import com.ram.Command.practice.RestaurantOrderManagementSystem.MenuItems.Item.Item;
import com.ram.Command.practice.RestaurantOrderManagementSystem.Commands.Status;

public class Order {

    private final int orderId;
    private final Item item;
    private final int quantity;
    private final int tableNo;
    private Status status;

    public Order(int orderId, Item item, int quantity, int tableNo) {
        this.orderId = orderId;
        this.item = item;
        this.quantity = quantity;
        this.tableNo = tableNo;
        this.status = Status.PLACED;
    }

    public int getOrderId() {
        return orderId;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTableNo() {
        return tableNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getTotalPrice() {
        return item.getPrice() * quantity;
    }
}
