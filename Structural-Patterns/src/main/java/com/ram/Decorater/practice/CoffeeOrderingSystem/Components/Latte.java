package com.ram.Decorater.practice.CoffeeOrderingSystem.Components;

public class Latte implements Coffee{
    @Override
    public String getDescription() {
        return "Latte";
    }

    @Override
    public double cost() {
        return 3.0;
    }
}
