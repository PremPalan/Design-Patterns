package com.ram.Bridge.practice.Abstractions;

import com.ram.Bridge.practice.Implementor.MessageSender;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OTPNotification extends Notification {
    private volatile int otp = -1;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public OTPNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notification() {
        sender.sendMessage("Leave", "sick leave for 2 days!");
    }

    public void generateOTP() {
        this.otp = (int) (Math.random() * 9000) + 1000;
        System.out.println("Your OTP: " + this.otp + " will last 3 sec");

        scheduler.schedule(() -> {
            this.otp = -1;
            System.out.println("OTP has expired.");
        }, 3, TimeUnit.SECONDS);
    }

    public int getOTP() {
        return otp;
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
