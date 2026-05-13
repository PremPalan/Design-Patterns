package com.ram.State.example;

import java.sql.SQLOutput;

interface VendingMachineState{
    void handleRequest();
}

class VendingMachine{
   private VendingMachineState state;

    public VendingMachine() {
        this.state = new ReadyState();
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void handleRequest(){
        state.handleRequest();
    }
}

class ReadyState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Ready state: Please select a product.");
    }
}

class ProductSelectedState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Product selected state: Processing payment.");
    }
}

class PaymentPendingState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Payment pending state: Dispensing product.");
    }
}

class OutOfStockState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Out of stock state: Product unavailable. Please select another product.");
    }
}

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.handleRequest();
        vendingMachine.setState(new ProductSelectedState());
        vendingMachine.handleRequest();
        vendingMachine.setState(new PaymentPendingState());
        vendingMachine.handleRequest();
        vendingMachine.setState(new OutOfStockState());
        vendingMachine.handleRequest();
    }
}
