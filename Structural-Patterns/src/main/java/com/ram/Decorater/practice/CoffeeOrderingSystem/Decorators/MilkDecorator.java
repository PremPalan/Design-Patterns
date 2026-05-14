package com.ram.Decorater.practice.CoffeeOrderingSystem.Decorators;

import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Coffee;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double cost(){
        return decoratedCoffee.cost() + 1.0;
    }
}
