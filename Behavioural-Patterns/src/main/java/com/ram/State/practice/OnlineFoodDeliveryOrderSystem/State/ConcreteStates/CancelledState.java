package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Customer;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.PaymentStatus;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.PaymentService.PaymentService;

public class CancelledState implements OrderState {
    private final PaymentService paymentService;
    private final Customer customer;

    public CancelledState(PaymentService paymentService, Customer customer) {
        this.paymentService = paymentService;
        this.customer = customer;
    }

    @Override
    public void handleRequest() {
        PaymentStatus status = paymentService.getPaymentStatus(customer.getOrder());
        if(status == PaymentStatus.REFUNDED) {
            System.out.println("Payment Refunded.........");
        }else{
            System.out.println("Error processing Refund........");
        }
    }
}
