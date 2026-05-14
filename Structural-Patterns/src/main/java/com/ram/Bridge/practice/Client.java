package com.ram.Bridge.practice;

import com.ram.Bridge.practice.Abstractions.*;
import com.ram.Bridge.practice.Implementor.*;

public class Client {
    public static void main(String[] args) {

        // EMAIL + SIMPLE
        Notification simpleEmail =
                new SimpleNotification(
                        new EmailSender("ram@gmail.com"));

        simpleEmail.notification();

        System.out.println("----------------");

        // SMS + ALERT
        Notification alertSMS =
                new AlertNotification(
                        new SMSender(9876543210L));

        alertSMS.notification();

        System.out.println("----------------");

        // PUSH + OTP
        OTPNotification otpPush =
                new OTPNotification(
                        new PushNotificationSender());

        otpPush.notification();

        otpPush.generateOTP();

        System.out.println("Current OTP: " + otpPush.getOTP());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("OTP After Expiry: " + otpPush.getOTP());

        otpPush.shutdown();
    }
}
