package com.ram.command.practice.smartHome;

class Button{
    Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }

    public void undo(){
        command.undo();
    }
}