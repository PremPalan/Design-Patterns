package com.ram.Decorater.practice.CoffeeOrderingSystem.Decorators;

import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee){
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost(){
        return decoratedCoffee.cost();
    }
}
