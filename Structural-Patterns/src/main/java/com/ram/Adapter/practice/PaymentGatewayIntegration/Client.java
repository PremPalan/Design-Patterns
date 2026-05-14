package com.ram.Adapter.practice.PaymentGatewayIntegration;

import com.ram.Adapter.practice.PaymentGatewayIntegration.Adapter.PayPalAdapter;
import com.ram.Adapter.practice.PaymentGatewayIntegration.Adapter.RazorpayAdapter;
import com.ram.Adapter.practice.PaymentGatewayIntegration.Adapter.StripeAdapter;
import com.ram.Adapter.practice.PaymentGatewayIntegration.Target.PaymentGateway;

public class Client{
    public static void processPayment(PaymentGateway gateway, double amount){
        gateway.pay(amount);
    }

    public static void main(String[] args) {

        PaymentGateway paypal = new PayPalAdapter();
        PaymentGateway razorpay = new RazorpayAdapter();
        PaymentGateway stripe = new StripeAdapter();

        System.out.println("===== PayPal Payment =====");
        processPayment(paypal, 500);

        System.out.println("===== Razorpay Payment =====");
        processPayment(razorpay, 1200);

        System.out.println("===== Stripe Payment =====");
        processPayment(stripe, 25.5);
    }
}