package com.ram.Bridge.practice.Abstractions;

import com.ram.Bridge.practice.Implementor.MessageSender;

public class SimpleNotification extends Notification{

    public SimpleNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notification() {
        sender.sendMessage("Leave", "sick leave for 2 days!");
    }
}
