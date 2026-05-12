package com.ram.Observer.practice.YoutubeNotificationSystem.Observer;

import com.ram.Observer.practice.YoutubeNotificationSystem.Event.VideoUploadedEvent;

public interface Subscriber {
    void update(VideoUploadedEvent event);
    String getSubscriberName();
    boolean isNotificationEnabled();
    String getInterestedCategory();
}
