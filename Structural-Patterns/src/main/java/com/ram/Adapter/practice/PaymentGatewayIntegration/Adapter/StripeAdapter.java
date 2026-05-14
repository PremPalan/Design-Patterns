package com.ram.Adapter.practice.PaymentGatewayIntegration.Adapter;

import com.ram.Adapter.practice.PaymentGatewayIntegration.Adaptee.StripeAPI;
import com.ram.Adapter.practice.PaymentGatewayIntegration.Target.PaymentGateway;

public class StripeAdapter implements PaymentGateway {
    private double currentDollarValueInRupees = 95.74f;
    private StripeAPI stripeAPI;

    public StripeAdapter(){
        this.stripeAPI = new StripeAPI();
    }

    @Override
    public void pay(double amount) {
        int charge = (int)(amount * currentDollarValueInRupees);
        stripeAPI.makeCharge(charge);
    }
}
