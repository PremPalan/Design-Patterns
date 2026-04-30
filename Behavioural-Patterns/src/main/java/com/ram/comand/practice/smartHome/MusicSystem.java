package com.ram.comand.practice.smartHome;

public class MusicSystem implements Device{

    public final String name;

    public MusicSystem(String name){
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning " + name + " On.......");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning " + name + " Off.......");
    }

    public void playSong(){
        System.out.println("Playing the Song......");
    }

    public void pauseSong(){
        System.out.println("Pausing the Song......");
    }

    public void increaseVolume(){
        System.out.println("Increasing the volume.......");
    }
}
