package com.ram.Observer.practice.YoutubeNotificationSystem.Observer;

import com.ram.Observer.practice.YoutubeNotificationSystem.Event.VideoUploadedEvent;

public class MobileSubscriber implements Subscriber{
    private final String phoneNo;
    private boolean enabled = true;
    private final String category;
    private VideoUploadedEvent event;

    public MobileSubscriber(String phoneNo, String category) {
        this.phoneNo = phoneNo;
        this.category = category;
    }


    @Override
    public void update(VideoUploadedEvent event) {
        this.event = event;
        display();
    }

    @Override
    public String getSubscriberName() {
        return phoneNo;
    }

    @Override
    public boolean isNotificationEnabled() {
        return enabled;
    }

    @Override
    public String getInterestedCategory() {
        return category;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCategory() {
        return category;
    }

    public void display(){
        System.out.println("For Mobile Subscribers: \n1) Video Title : " + event.getVideoTitle() + "\n2)Category : " + event.getCategory() + "\n3) Upload Time : " + event.getUploadtime() + "\n4) Channel Name : " + event.getChannelName() + "\n");
    }
}
