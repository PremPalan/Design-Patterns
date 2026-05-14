package com.ram.Bridge.practice.Implementor;

public class SMSender implements MessageSender{
    private final long phoneNumber;

    public SMSender(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendMessage(String title, String content) {
        System.out.println("From Number : " + phoneNumber);
        System.out.println(title);
        System.out.println(content);
    }
}
