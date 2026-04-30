package com.ram.comand.practice.smartHome;

import java.util.ArrayList;
import java.util.List;

class SmartRemote{
    Button button1 = new Button();
    Button button2 = new Button();
    Button button3 = new Button();
    Button button4 = new Button();
    Button button5 = new Button();

    List<Button> buttons = new ArrayList<>();
    Command command;
    boolean push = false;

    public void setButtons(){
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
    }

    public void setCommand(Command command, int num){
        Button button = buttons.get(num-1);
        this.command = command;

        button.setCommand(command);
    }

    public void pushButton(int num) {
        Button button = buttons.get(num - 1);
        if (!push) {
            button.pressButton();
            push = true;
        } else {
            button.undo();
            push = false;
        }
    }
}
