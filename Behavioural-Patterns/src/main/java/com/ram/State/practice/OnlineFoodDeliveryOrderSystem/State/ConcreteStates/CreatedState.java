package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Customer;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.PaymentService.PaymentService;

public class CreatedState implements OrderState {

    private final PaymentService paymentService;
    private final Customer customer;

    public CreatedState(PaymentService paymentService, Customer customer) {
        this.paymentService = paymentService;
        this.customer = customer;
    }

    @Override
    public void handleRequest() {
        if(paymentService.processPayment(customer.getOrder(), customer.getOrder().getTotalPrice())){
            System.out.println("Payment processed successfully ......");
        }else{
            System.out.println("Invalid Payment.......");
        }
    }
}
