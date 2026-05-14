package com.ram.Adapter.practice.PaymentGatewayIntegration.Adaptee;

public class StripeAPI {
    public void makeCharge(int cents){
        System.out.println("Making Charge via Stripe of " + cents + " cents.\n");
    }
}
