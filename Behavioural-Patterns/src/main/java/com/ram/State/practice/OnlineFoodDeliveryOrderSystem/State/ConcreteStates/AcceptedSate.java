package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.ConcreteStates;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.State.OrderState;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.NotificationService.Observer.Customer;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.PaymentStatus;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.PaymentService.PaymentService;

public class AcceptedSate implements OrderState {

    private final PaymentService paymentService;
    private final Customer customer;

    public AcceptedSate(PaymentService paymentService, Customer customer) {
        this.paymentService = paymentService;
        this.customer = customer;
    }

    @Override
    public void handleRequest() {
        PaymentStatus status = paymentService.getPaymentStatus(customer.getOrder());
        if(status == PaymentStatus.SUCCESS){
            System.out.println("Payment Success.........");
        }else if(status == PaymentStatus.FAILED){
            System.out.println("Payment Failed.......");
        } else if (status == PaymentStatus.PENDING) {
            System.out.println("Payment Pending.........");
        }else{
            System.out.println("Payment Error.......");
        }
    }
}
