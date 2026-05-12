package com.ram.Iterator.practice.ReverseIterator.Iterator;

import com.ram.Iterator.practice.ReverseIterator.Playlist;

import java.util.List;

public abstract class MusicList<Playlist> {
    protected final List<Playlist> playlist;
    protected int currentIndex = 0;

    public MusicList(List<Playlist> playlist) {
        this.playlist = playlist;
    }
}
