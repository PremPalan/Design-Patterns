package com.ram.Bridge.example;

abstract class Vehicle{
    protected WorkShop workShop1, workShop2;

    public Vehicle(WorkShop workShop1, WorkShop workShop2){
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
}

class Car extends Vehicle{
    public Car(WorkShop workShop1, WorkShop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }
}

class Bike extends Vehicle {
    public Bike(WorkShop workShop1, WorkShop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
    }
}

interface WorkShop{
    void work();
}

class Produce implements WorkShop {
    @Override
    public void work()
    {
        System.out.print("Produced");
    }
}

class Assemble implements WorkShop {
    @Override
    public void work()
    {
        System.out.print(" And");
        System.out.println(" Assembled.");
    }
}

public class Main {
    public static void main(String[] args)
    {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();
    }
}
