package com.ram.Observer.practice.YoutubeNotificationSystem.Event;

import java.sql.Time;
import java.time.LocalDateTime;

public class VideoUploadedEvent {
    private final String videoTitle;
    private final String category;
    private final LocalDateTime uploadtime;
    private final String channelName;

    public VideoUploadedEvent(String videoTitle, String category, LocalDateTime uploadtime, String channelName) {
        this.videoTitle = videoTitle;
        this.category = category;
        this.uploadtime = uploadtime;
        this.channelName = channelName;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getUploadtime() {
        return uploadtime;
    }

    public String getChannelName() {
        return channelName;
    }
}
