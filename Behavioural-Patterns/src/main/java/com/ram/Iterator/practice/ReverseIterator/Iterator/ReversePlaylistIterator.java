package com.ram.Iterator.practice.ReverseIterator.Iterator;

import com.ram.Iterator.practice.ReverseIterator.Playlist;

import java.util.List;

public class ReversePlaylistIterator extends MusicList<Playlist> implements Iterator<Playlist>{

    public ReversePlaylistIterator(List<Playlist> playlist){
        super(playlist);
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Playlist next() {
        return playlist.get(currentIndex--);
    }
}
