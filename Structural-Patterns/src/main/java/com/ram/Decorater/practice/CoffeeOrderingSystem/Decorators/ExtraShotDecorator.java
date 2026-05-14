package com.ram.Decorater.practice.CoffeeOrderingSystem.Decorators;

import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Cappuccino;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Coffee;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Espresso;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.Latte;

public class ExtraShotDecorator extends CoffeeDecorator{
    private Coffee baseCoffee = new Espresso();
    private String[] descriptionSplit;
    private String description;

    public ExtraShotDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription(){
        this.description = decoratedCoffee.getDescription();
        return decoratedCoffee.getDescription() + ", extraShot" + baseCoffee.getDescription();
    }

    @Override
    public double cost(){
        descriptionSplit = description.split(", ");
        if(descriptionSplit[0].equals("Latte")){
            baseCoffee = new Latte();
        }else if(descriptionSplit[0].equals("Cappuccino")){
            baseCoffee = new Cappuccino();
        }else if(descriptionSplit[0].equals("Espresso")){
            baseCoffee = new Espresso();
        }

        return decoratedCoffee.cost() + baseCoffee.cost();
    }
}
