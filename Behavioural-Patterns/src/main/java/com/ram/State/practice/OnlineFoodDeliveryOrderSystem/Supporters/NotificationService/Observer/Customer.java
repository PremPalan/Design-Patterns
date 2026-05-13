package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Location.Location;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;

import java.util.UUID;

public class Customer implements Observer{
    private final UUID customerId;
    private final String customerName;
    private final String address;
    private final Location location;
    private Order order;

    public Customer(UUID customerId, String customerName, String address, Location location, Order order) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.location = location;
        this.order = order;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void update(OrderState state) {
        state.handleRequest();
    }
}
