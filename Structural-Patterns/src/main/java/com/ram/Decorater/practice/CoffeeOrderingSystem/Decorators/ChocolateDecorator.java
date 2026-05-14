package com.ram.Decorater.practice.CoffeeOrderingSystem.Decorators;

import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Coffee;

public class ChocolateDecorator extends CoffeeDecorator{
    public ChocolateDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription() + ", Chocolate";
    }

    @Override
    public double cost(){
        return decoratedCoffee.cost() + 1.5;
    }
}
