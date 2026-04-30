package com.ram.command.example;

interface Command {
    void execute();
}

interface Device {
    void turnOn();
    void turnOff();
}

class TurnOnCommand implements Command {
    private final Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements Command {
    private final Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

class AdjustVolumeCommand implements Command {
    private final Stereo stereo;

    public AdjustVolumeCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.adjustVolume();
    }
}

class ChangeChannelCommand implements Command {
    private final TV tv;

    public ChangeChannelCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}

class TV implements Device {
    private final String name;

    public TV(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning " + name + " TV on.......");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning " + name + " TV off.......");
    }

    public void changeChannel() {
        System.out.println("Changing Channel........");
    }
}

class Stereo implements Device {
    private final String name;

    public Stereo(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning " + name + " Stereo on.......");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning " + name + " Stereo off.......");
    }

    public void adjustVolume() {
        System.out.println("Adjusting Volume......");
    }
}

class Remote {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pushButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned.");
        }
    }
}

public class main {
    public static void main(String[] args) {

        TV sonyTv = new TV("Sony");
        Stereo jblStereo = new Stereo("JBL");

        Remote remote = new Remote();

        remote.setCommand(new TurnOnCommand(sonyTv));
        remote.pushButton();

        remote.setCommand(new ChangeChannelCommand(sonyTv));
        remote.pushButton();

        remote.setCommand(new TurnOffCommand(sonyTv));
        remote.pushButton();

        remote.setCommand(new TurnOnCommand(jblStereo));
        remote.pushButton();

        remote.setCommand(new AdjustVolumeCommand(jblStereo));
        remote.pushButton();

        remote.setCommand(new TurnOffCommand(jblStereo));
        remote.pushButton();
    }
}