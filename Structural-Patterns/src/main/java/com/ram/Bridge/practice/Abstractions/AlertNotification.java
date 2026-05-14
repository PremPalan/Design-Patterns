package com.ram.Bridge.practice.Abstractions;

import com.ram.Bridge.practice.Implementor.MessageSender;

public class AlertNotification extends Notification{
    public AlertNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notification() {
        System.out.println("[[ALERT]]");
        sender.sendMessage("Leave", "sick leave for 2 days!");
    }
}
