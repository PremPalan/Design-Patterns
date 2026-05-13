package com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.PaymentService;

import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Invoice;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.Order;
import com.ram.State.practice.OnlineFoodDeliveryOrderSystem.Supporters.Order.PaymentStatus;

public class PaymentService {
    private boolean isProcessed = true;

    public boolean processPayment(Order order, float amount){
        return isProcessed;
    }

    public float refundPayment(Order order){
        return order.getTotalPrice();
    }

    public PaymentStatus getPaymentStatus(Order order){
        if(processPayment(order, order.getTotalPrice())){
            return PaymentStatus.SUCCESS;
        }else if(!processPayment(order, order.getTotalPrice())){
            return PaymentStatus.FAILED;
        }

        return PaymentStatus.PENDING;
    }

    public Invoice generateInvoice(Order order){
        return new Invoice(order.getOrder(), order.getTotalPrice());
    }
}
