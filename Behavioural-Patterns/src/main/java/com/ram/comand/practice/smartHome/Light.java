package com.ram.comand.practice.smartHome;

public class Light implements Device{

    @Override
    public void turnOn() {
        System.out.println("Turning Lights On.....");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Lights Off.....");
    }

    public void dimLights(){
        System.out.println("Dimming the Lights.......");
    }
}
