package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private List<Item> order = new ArrayList<>();
    private float totalPrice = 0;
    private OrderStatus status = OrderStatus.NOTREADY;

    public void addItem(Item item){
        order.add(item);
        totalPrice += item.getPrice();
    }

    public void removeItem(Item item){
        order.remove(item);
        totalPrice -= item.getPrice();
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public List<Item> getOrder() {
        return order;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
