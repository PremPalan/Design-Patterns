package com.ram.Observer.practice.YoutubeNotificationSystem.Observer;

import com.ram.Observer.practice.YoutubeNotificationSystem.Event.VideoUploadedEvent;

public class SmartTVSubscriber implements Subscriber{
    private final String TVid;
    private boolean enabled = true;
    private final String category;
    private VideoUploadedEvent event;

    public SmartTVSubscriber(String TVid, String category) {
        this.TVid = TVid;
        this.category = category;
    }

    @Override
    public void update(VideoUploadedEvent event) {
        this.event = event;
        display();
    }

    @Override
    public String getSubscriberName() {
        return TVid;
    }

    @Override
    public boolean isNotificationEnabled() {
        return enabled;
    }

    @Override
    public String getInterestedCategory() {
        return category;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTVid() {
        return TVid;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getCategory() {
        return category;
    }

    public void display(){
        System.out.println("For SmartTV Subscribers: \n1) Video Title : " + event.getVideoTitle() + "\n2)Category : " + event.getCategory() + "\n3) Upload Time : " + event.getUploadtime() + "\n4) Channel Name : " + event.getChannelName() + "\n");
    }
}
