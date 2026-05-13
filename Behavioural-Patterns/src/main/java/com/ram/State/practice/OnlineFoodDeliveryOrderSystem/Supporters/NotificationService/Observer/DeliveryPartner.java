package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Location.Location;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;

import java.util.UUID;

public class DeliveryPartner implements Observer{
    private UUID partnerId;
    private String name;
    private boolean isAvailable = true;
    private Location location = null;

    public boolean acceptOrder(Order order, Restaurant restaurant){
        if(calculateDistanceToRestaurant(restaurant) <= 10){
            System.out.println("Order Accepted by : " + name);
            return true;
        }

        return false;
    }

    public void pickupOrder(Order order, Restaurant restaurant){
        System.out.println("Order picked up by : " + name + "\nfrom : " + restaurant.getRestaurantName());
    }

    public void deliverOrder(Order order, Customer customer){
        System.out.println("Delivering order to : " + customer.getCustomerName() + "\naddress : " + customer.getAddress());
    }

    public void updateLocation(Location location){
        this.location = location;
    }

    public void markUnavailable(){
        this.isAvailable = !isAvailable;
    }

    float calculateDistanceToRestaurant(Restaurant restaurant){

        float lat1 = location.getLatitude();
        float lat2 = restaurant.getLocation().getLatitude();

        float lon1 = location.getLongitude();
        float lon2 = restaurant.getLocation().getLongitude();

        final float R = 6371;

        // Convert degrees to radians
        float dLat = (float) Math.toRadians(lat2 - lat1);
        float dLon = (float) Math.toRadians(lon2 - lon1);

        float a = (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2));

        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));

        return R * c;
    }

    @Override
    public void update(OrderState state) {
        state.handleRequest();
    }
}
