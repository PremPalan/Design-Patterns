package com.ram.State.practice.OnlineFoodDeliveryOrderSystem;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Context.FoodOrder;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.AcceptedSate;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.CancelledState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.CreatedState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.DeliveredState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.OutForDeliveryState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.PreparingState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates.RefundState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Location.Location;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Customer;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.DeliveryPartner;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Restaurant;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Subject.NotificationService;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Invoice;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Item;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.PaymentService.PaymentService;

import java.lang.reflect.Field;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Burger", 120.0f));
        order.addItem(new Item("Fries", 60.0f));
        order.addItem(new Item("Coke", 40.0f));

        setPrivateField(order, "orderId", UUID.randomUUID());

        Location customerLocation = new Location(19.0760f, 72.8777f);
        Location restaurantLocation = new Location(19.0765f, 72.8780f);
        Location deliveryPartnerLocation = new Location(19.0762f, 72.8779f);

        Customer customer = new Customer(
                UUID.randomUUID(),
                "Ram",
                "Mumbai",
                customerLocation,
                order
        );

        Restaurant restaurant = new Restaurant("Spicy Corner", restaurantLocation);

        DeliveryPartner deliveryPartner = new DeliveryPartner();
        setPrivateField(deliveryPartner, "name", "Aman");
        setPrivateField(deliveryPartner, "location", deliveryPartnerLocation);

        PaymentService paymentService = new PaymentService();
        FoodOrder foodOrder = new FoodOrder();

        System.out.println("======== ORDER SUMMARY ========");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Items count: " + order.getOrder().size());
        System.out.println("Total before GST: " + order.getTotalPrice());
        System.out.println("Current status: " + order.getStatus());

        System.out.println("\n======== DIRECT INVOICE TEST ========");
        Invoice invoice = paymentService.generateInvoice(order);
        invoice.display();

        System.out.println("\n======== STATE FLOW TEST ========");

        foodOrder.setState(new CreatedState(paymentService, customer));
        foodOrder.handleRequest();

        foodOrder.setState(new AcceptedSate(paymentService, customer));
        foodOrder.handleRequest();

        foodOrder.setState(new PreparingState(restaurant, customer));
        foodOrder.handleRequest();
        System.out.println("Order status after preparing: " + order.getStatus());

        foodOrder.setState(new OutForDeliveryState(restaurant, deliveryPartner, customer));
        foodOrder.handleRequest();

        foodOrder.setState(new DeliveredState(paymentService, customer));
        foodOrder.handleRequest();

        System.out.println("\n======== POST-DELIVERY INVOICE TEST ========");
        paymentService.generateInvoice(order).display();

        System.out.println("\n======== PAYMENT REFUND TEST ========");
        System.out.println("Refund amount returned by service: " + paymentService.refundPayment(order));

        System.out.println("\n======== FORCED PAYMENT FAILURE TEST ========");
        setPrivateField(paymentService, "isProcessed", false);
        System.out.println("Payment status after forcing failure: " + paymentService.getPaymentStatus(order));

        foodOrder.setState(new CancelledState(paymentService, customer));
        foodOrder.handleRequest();

        System.out.println("\n======== REFUND STATE TEST ========");
        foodOrder.setState(new RefundState());
        foodOrder.handleRequest();

        System.out.println("\n======== OBSERVER TEST ========");
        NotificationService notificationService = new NotificationService();

        notificationService.addObserver(customer);
        notificationService.setOrderState(new CreatedState(paymentService, customer));
        notificationService.removeObserver(customer);

        notificationService.addObserver(restaurant);
        notificationService.setOrderState(new PreparingState(restaurant, customer));
        notificationService.removeObserver(restaurant);

        notificationService.addObserver(deliveryPartner);
        notificationService.setOrderState(new OutForDeliveryState(restaurant, deliveryPartner, customer));
        notificationService.removeObserver(deliveryPartner);

        System.out.println("\n======== TEST COMPLETE ========");
    }

    private static void setPrivateField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Could not set field '" + fieldName + "' on " + target.getClass().getSimpleName(),
                    e
            );
        }
    }
}