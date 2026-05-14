package com.ram.Decorater.practice.CoffeeOrderingSystem;

import com.ram.Decorater.practice.CoffeeOrderingSystem.Components.*;
import com.ram.Decorater.practice.CoffeeOrderingSystem.Decorators.*;

public class Client {

    public static void printCoffee(Coffee coffee){
        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.cost());
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        // Basic Latte
        Coffee coffee1 = new Latte();
        printCoffee(coffee1);

        // Latte + Milk
        Coffee coffee2 =
                new MilkDecorator(
                        new Latte()
                );
        printCoffee(coffee2);

        // Espresso + Chocolate + Extra Shot
        Coffee coffee3 =
                new ExtraShotDecorator(
                        new ChocolateDecorator(
                                new Espresso()
                        )
                );
        printCoffee(coffee3);

        // Cappuccino + Milk + Chocolate + Large
        Coffee coffee4 =
                new LargeSizeDecorator(
                        new ChocolateDecorator(
                                new MilkDecorator(
                                        new Cappuccino()
                                )
                        )
                );
        printCoffee(coffee4);

        // Ultimate Coffee
        Coffee ultimate =
                new LargeSizeDecorator(
                        new ExtraShotDecorator(
                                new ChocolateDecorator(
                                        new MilkDecorator(
                                                new Latte()
                                        )
                                )
                        )
                );

        printCoffee(ultimate);
    }
}
