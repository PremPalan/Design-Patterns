package com.ram.command.practice.smartHome;

public class AC implements Device{

    private final String name;

    public AC(String name){
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning AC On.......");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning AC Off.......");
    }

    public void setTemperature(int value){
        System.out.println("Setting AC temperature to " + value);
    }
}
