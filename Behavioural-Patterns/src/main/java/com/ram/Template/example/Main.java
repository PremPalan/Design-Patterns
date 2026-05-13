package com.ram.Template.example;

abstract class BeverageMaker{
    public void makeBeverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public abstract void brew();
    public abstract void addCondiments();

    public void pourInCup(){
        System.out.println("Pouring in Cup .....");
    }

    public void boilWater(){
        System.out.println("Boiling Water ......");
    }
}

class TeaMaker extends BeverageMaker{

    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class CoffeeMaker extends BeverageMaker{

    @Override
    public void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Making tea:");
        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.makeBeverage();

        System.out.println("\nMaking coffee:");
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
    }
}
