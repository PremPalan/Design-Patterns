package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Customer;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.DeliveryPartner;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Restaurant;

public class OutForDeliveryState implements OrderState {
    private final Restaurant restaurant;
    private final DeliveryPartner deliveryPartner;
    private final Customer customer;

    public OutForDeliveryState(Restaurant restaurant, DeliveryPartner deliveryPartner, Customer customer) {
        this.restaurant = restaurant;
        this.deliveryPartner = deliveryPartner;
        this.customer = customer;
    }

    @Override
    public void handleRequest() {
        if(deliveryPartner.acceptOrder(customer.getOrder(), restaurant)){
            deliveryPartner.pickupOrder(customer.getOrder(), restaurant);
            deliveryPartner.updateLocation(restaurant.getLocation());
            deliveryPartner.deliverOrder(customer.getOrder(), customer);
            deliveryPartner.updateLocation(customer.getLocation());
        }
    }
}
