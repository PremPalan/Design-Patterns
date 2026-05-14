package com.ram.Bridge.practice.Implementor;

public class PushNotificationSender implements MessageSender{
    @Override
    public void sendMessage(String title, String content) {
        System.out.println(title);
        System.out.println(content);
    }
}
