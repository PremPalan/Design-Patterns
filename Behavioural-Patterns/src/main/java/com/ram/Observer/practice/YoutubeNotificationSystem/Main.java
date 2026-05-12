package com.ram.Observer.practice.YoutubeNotificationSystem;

import com.ram.Observer.practice.YoutubeNotificationSystem.Event.VideoUploadedEvent;
import com.ram.Observer.practice.YoutubeNotificationSystem.Observer.EmailSubscriber;
import com.ram.Observer.practice.YoutubeNotificationSystem.Observer.MobileSubscriber;
import com.ram.Observer.practice.YoutubeNotificationSystem.Observer.SmartTVSubscriber;
import com.ram.Observer.practice.YoutubeNotificationSystem.Observer.Subscriber;
import com.ram.Observer.practice.YoutubeNotificationSystem.Subject.YoutubeChannel;
import com.ram.Observer.practice.YoutubeNotificationSystem.Subject.YoutubeChannelImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel mrBeast = new YoutubeChannelImpl("MrBeast");
        Subscriber emailS = new EmailSubscriber("ramram@gmail.com", "Sports");
        Subscriber phoneS = new MobileSubscriber("7651005628", "Cooking");
        Subscriber smartTVS = new SmartTVSubscriber("Sony", "Music");

        mrBeast.subscribe(emailS);
        mrBeast.subscribe(phoneS);
        mrBeast.subscribe(smartTVS);

        VideoUploadedEvent event = new VideoUploadedEvent("100 people competing for one private jet",
                "Sports",
                LocalDateTime.now(),
                "MrBeast");

        mrBeast.uploadVideo(event);
    }
}
