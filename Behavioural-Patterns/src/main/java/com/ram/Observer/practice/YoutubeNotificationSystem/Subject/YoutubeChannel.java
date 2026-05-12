package com.ram.Observer.practice.YoutubeNotificationSystem.Subject;

import com.ram.Observer.practice.YoutubeNotificationSystem.Event.VideoUploadedEvent;
import com.ram.Observer.practice.YoutubeNotificationSystem.Observer.Subscriber;

public interface YoutubeChannel {
    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void notifySubscribers(VideoUploadedEvent event);
    void uploadVideo(VideoUploadedEvent event);
}
