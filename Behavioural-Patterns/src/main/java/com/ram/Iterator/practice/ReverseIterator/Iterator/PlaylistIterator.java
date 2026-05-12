package com.ram.Iterator.practice.ReverseIterator.Iterator;

import com.ram.Iterator.practice.ReverseIterator.Playlist;

import java.util.List;
import java.util.NoSuchElementException;

public class PlaylistIterator extends MusicList<Playlist> implements Iterator<Playlist>{

    public PlaylistIterator(List<Playlist> playlist){
        super(playlist);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < playlist.size();
    }

    @Override
    public Playlist next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return playlist.get(currentIndex++);
    }
}
