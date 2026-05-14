package com.ram.Adapter.practice.PaymentGatewayIntegration.Adapter;

import com.ram.Adapter.practice.PaymentGatewayIntegration.Adaptee.PayPalAPI;
import com.ram.Adapter.practice.PaymentGatewayIntegration.Target.PaymentGateway;

public class PayPalAdapter implements PaymentGateway {
    private PayPalAPI payPalAPI;

    public PayPalAdapter(){
        this.payPalAPI = new PayPalAPI();
    }

    @Override
    public void pay(double amount) {
        payPalAPI.sendPayment(amount);
    }
}
