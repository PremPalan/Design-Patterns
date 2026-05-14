package com.ram.Adapter.practice.PaymentGatewayIntegration.Adaptee;

public class RazorpayAPI {
    public void doPayment(String currency , double amount){
        System.out.println("Doing Payment via RazorAPI of amount : " + currency + amount + ".\n");
    }
}
