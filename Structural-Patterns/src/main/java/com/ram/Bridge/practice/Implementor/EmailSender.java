package com.ram.Bridge.practice.Implementor;

public class EmailSender implements MessageSender{

    private final String email;

    public EmailSender(String email) {
        this.email = email;
    }

    @Override
    public void sendMessage(String title, String content) {
        System.out.println("From Email : " + email);
        System.out.println(title);
        System.out.println(content);
    }
}
