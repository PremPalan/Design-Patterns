package com.ram.Bridge.practice.Abstractions;

import com.ram.Bridge.practice.Implementor.MessageSender;

public abstract class Notification {
    protected MessageSender sender;

    public Notification(MessageSender sender){
        this.sender = sender;
    }

    abstract public void notification();
}
