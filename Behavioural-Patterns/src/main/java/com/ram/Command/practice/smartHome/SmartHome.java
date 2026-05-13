package com.ram.Command.practice.smartHome;

import java.util.Scanner;

//Commands
class TurnOnLightCommand implements Command{
    Device device;

    public TurnOnLightCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }

    @Override
    public void undo() {
        device.turnOff();
    }
}

class TurnOffLightCommand implements Command{
    Device device;

    public TurnOffLightCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }

    @Override
    public void undo() {
        device.turnOn();
    }
}

class IncreaseFanSpeedCommand implements Command{
    Fan fan;

    public IncreaseFanSpeedCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.increaseSpeed();
    }

    @Override
    public void undo() {
        fan.decreaseSpeed();
    }
}

class SetACTempCommand implements Command{
    AC ac;
    int num;

    public SetACTempCommand(AC ac, int num ){
        this.ac = ac;
        this.num = num;
    }

    @Override
    public void execute() {
        ac.setTemperature(num);
    }

    @Override
    public void undo() {
        ac.setTemperature(24);
    }
}

class OpenGarageCommand implements Command{

    Garage garage;

    public OpenGarageCommand(Garage garage){
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.turnOn();
    }

    @Override
    public void undo() {
        garage.turnOff();
    }
}

class PlayMusicCommand implements Command{

    MusicSystem musicSystem;

    public PlayMusicCommand(MusicSystem musicSystem){
        this.musicSystem = musicSystem;
    }

    @Override
    public void execute() {
        musicSystem.playSong();
    }

    @Override
    public void undo() {
        musicSystem.pauseSong();
    }

    public void increaseSound(){
        musicSystem.increaseVolume();
    }
}

class MovieModeCommand implements Command{
    Light light;
    AC ac;
    MusicSystem musicSystem;

    public MovieModeCommand(Light light, AC ac, MusicSystem musicSystem){
        this.ac = ac;
        this.musicSystem = musicSystem;
        this.light = light;
    }

    @Override
    public void execute() {
        light.dimLights();
        ac.turnOn();
        musicSystem.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
        ac.turnOff();
        musicSystem.turnOn();
    }
}

public class SmartHome {
    public static void main(String[] args) {

        //Devices
        AC LG_Ac = new AC("LG");
        Light Light = new Light();
        Device Fan = new Fan();
        Device Garage = new Garage();
        MusicSystem JBLMusic = new MusicSystem("JBL");

        //Remote Config
        SmartRemote remote = new SmartRemote();
        remote.setButtons();

        String choice = "Null";
        // dynamic setting
        Scanner sc =new Scanner(System.in);

        while(!choice.equals("Exit")){
            System.out.println("Choose Device.....\n 1) Light\n 2) Fan\n 3) Garage\n 4) MusicSystem\n 5) AC\n 6) " +
                    "MovieMode\n 7) Exit\n");
            choice = sc.nextLine();
            Device temp = null;
            if(choice.equals("Light")){
                temp = Light;
            }else if(choice.equals("Fan")){
                temp = Fan;
            }else if(choice.equals("Garage")){
                temp = Garage;
            }else if(choice.equals("MusicSystem")){
                temp = JBLMusic;
            }else if(choice.equals("AC")){
                temp = LG_Ac;
            }else if(choice.equals("MovieMode")){
                remote.setCommand(new MovieModeCommand(Light, LG_Ac, JBLMusic), 5);
            }

            if(temp != null){
                remote.setCommand(new TurnOnLightCommand(temp),1);
                remote.setCommand(new TurnOffLightCommand(temp),2);
            }

            if(temp instanceof AC){
                remote.setCommand(new SetACTempCommand((AC) temp,18), 3);
            }else if(temp instanceof Fan){
                remote.setCommand(new IncreaseFanSpeedCommand((Fan) temp),3);
            }else if(temp instanceof Garage){
                remote.setCommand(new OpenGarageCommand((Garage) temp), 1);
            }else if(temp instanceof MusicSystem){
                remote.setCommand(new PlayMusicCommand((MusicSystem) temp),4);
            }

            //ask user for button
            int number;
            System.out.println("Press Button 1,2,3,4,5");
            number = sc.nextInt();

            //execute
            remote.pushButton(number);
        }

    }
}
