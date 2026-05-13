package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Customer;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Restaurant;

public class PreparingState implements OrderState {
    private final Restaurant restaurant;
    private final Customer customer;

    public PreparingState(Restaurant restaurant, Customer customer) {
        this.restaurant = restaurant;
        this.customer = customer;
    }

    @Override
    public void handleRequest() {
        restaurant.acceptOrder(customer.getOrder());
        restaurant.startPreparing(customer.getOrder());
        restaurant.markReadyForPickup(customer.getOrder());
    }
}
