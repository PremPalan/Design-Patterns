package com.ram.Iterator.practice.ReverseIterator.Aggregate;

import com.ram.Iterator.practice.ReverseIterator.Iterator.Iterator;
import com.ram.Iterator.practice.ReverseIterator.Iterator.PlaylistIterator;
import com.ram.Iterator.practice.ReverseIterator.Iterator.ReversePlaylistIterator;
import com.ram.Iterator.practice.ReverseIterator.Playlist;

import java.util.List;

public class Spotify implements Aggregate<Playlist>{
    private final List<Playlist> playlist;

    public Spotify(List<Playlist> playlist){
        this.playlist = playlist;
    }

    @Override
    public Iterator<Playlist> createPlaylistIterator() {
        return new PlaylistIterator(playlist);
    }

    @Override
    public Iterator<Playlist> createReversePlaylistIterator() {
        return new ReversePlaylistIterator(playlist);
    }
}
