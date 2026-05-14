package com.ram.Adapter.practice.PaymentGatewayIntegration.Adapter;

import com.ram.Adapter.practice.PaymentGatewayIntegration.Adaptee.RazorpayAPI;
import com.ram.Adapter.practice.PaymentGatewayIntegration.Target.PaymentGateway;

public class RazorpayAdapter implements PaymentGateway {
    private RazorpayAPI razorpayAPI;
    private final String defaultCurrency = "INR";

    public RazorpayAdapter(){
        this.razorpayAPI = new RazorpayAPI();
    }

    @Override
    public void pay(double amount) {
        razorpayAPI.doPayment(defaultCurrency, amount);
    }
}
