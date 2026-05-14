package com.ram.Decorater.practice.CoffeeOrderingSystem.Components;

public class Espresso implements Coffee{
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 4.0;
    }
}
