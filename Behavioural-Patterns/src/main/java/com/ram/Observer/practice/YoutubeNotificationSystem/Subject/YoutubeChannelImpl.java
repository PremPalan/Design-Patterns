package com.ram.Observer.practice.YoutubeNotificationSystem.Subject;

import com.ram.Observer.practice.YoutubeNotificationSystem.Event.VideoUploadedEvent;
import com.ram.Observer.practice.YoutubeNotificationSystem.Observer.Subscriber;


import java.util.ArrayList;
import java.util.List;

public class YoutubeChannelImpl implements YoutubeChannel{
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final String channelName;
    private VideoUploadedEvent event;

    public YoutubeChannelImpl(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void notifySubscribers(VideoUploadedEvent event) {
        for(Subscriber it: subscribers){
            it.update(event);
        }
    }

    @Override
    public void uploadVideo(VideoUploadedEvent event) {
        this.event = event;
        notifySubscribers(event);
    }
}
