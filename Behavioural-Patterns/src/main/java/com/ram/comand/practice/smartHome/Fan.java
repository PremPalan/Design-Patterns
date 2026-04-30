package com.ram.comand.practice.smartHome;

public class Fan implements Device{
    @Override
    public void turnOn() {
        System.out.println("Turning the Fan On......");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning the Fan Off.........");
    }

    public void increaseSpeed(){
        System.out.println("Increasing fan speed.......");
    }

    public void decreaseSpeed(){
        System.out.println("Decreasing fan speed........");
    }
}
