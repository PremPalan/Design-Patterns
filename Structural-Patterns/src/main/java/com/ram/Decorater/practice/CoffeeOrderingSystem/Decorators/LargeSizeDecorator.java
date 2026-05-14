package com.ram.Decorater.practice.CoffeeOrderingSystem.Decorators;

import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Cappuccino;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Coffee;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Espresso;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Latte;

public class LargeSizeDecorator extends CoffeeDecorator{

    public LargeSizeDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription() + ", Large";
    }

    @Override
    public double cost(){
        return decoratedCoffee.cost() * 1.2;
    }
}
