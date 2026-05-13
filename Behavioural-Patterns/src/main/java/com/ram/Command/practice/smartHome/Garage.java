package com.ram.Command.practice.smartHome;

public class Garage implements Device{
    @Override
    public void turnOn() {
        System.out.println("Opening the Garage......");
    }

    @Override
    public void turnOff() {
        System.out.println("Closing the Garage.....");
    }
}
