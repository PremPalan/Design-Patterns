package com.ram.Facade.practice.OnlineDeliverySystem.Facade;

import com.ram.Facade.practice.OnlineDeliverySystem.Subsytems.*;

import java.util.List;


public class FoodDeliveryFacade {

    private RestaurantService restaurantService;
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private DeliveryService deliveryService;
    private NotificationService notificationService;

    public FoodDeliveryFacade() {
        restaurantService = new RestaurantService();
        inventoryService = new InventoryService();
        paymentService = new PaymentService();
        deliveryService = new DeliveryService();
        notificationService = new NotificationService();
    }

    public void placeOrder(List<String> items, double amount) {

        if(!restaurantService.validateRestaurant(101)) {
            System.out.println("Invalid restaurant");
            return;
        }

        if(!inventoryService.checkAvailability(items)) {
            System.out.println("Items unavailable");
            return;
        }

        if(!paymentService.pay(amount)) {
            System.out.println("Payment failed");
            return;
        }

        deliveryService.assignPartner();

        notificationService.sendNotification();

        System.out.println("Order placed successfully");
    }
}
