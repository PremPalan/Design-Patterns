package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Location.Location;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.OrderStatus;

public class Restaurant implements Observer{

    private String restaurantName;
    private Location location;

    public Restaurant(String restaurantName, Location location) {
        this.restaurantName = restaurantName;
        this.location = location;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean acceptOrder(Order order){
        return true;
    }

    public void startPreparing(Order order){
        System.out.println("preparing the order : " + order.getOrderId());
    }

    public void markReadyForPickup(Order order){
        order.setStatus(OrderStatus.READY);
    }

    @Override
    public void update(OrderState state) {
        state.handleRequest();
    }
}
