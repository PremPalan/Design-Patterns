package com.ram.Adapter.practice.PaymentGatewayIntegration.Adaptee;

public class PayPalAPI {
    public void sendPayment(double amount){
        System.out.println("Sending Payment via PayPalAPI of amount : " + amount + ".\n");
    }
}
