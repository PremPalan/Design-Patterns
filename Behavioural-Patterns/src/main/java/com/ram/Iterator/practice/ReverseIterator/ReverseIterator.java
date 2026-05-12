package com.ram.Iterator.practice.ReverseIterator;

import com.ram.Iterator.practice.ReverseIterator.Aggregate.Spotify;
import com.ram.Iterator.practice.ReverseIterator.Iterator.Iterator;


import java.util.ArrayList;
import java.util.List;

public class ReverseIterator {
    public static void main(String[] args) {
        List<Playlist> playlist = new ArrayList<>();
        playlist.add(new Playlist("Chahun mai aana", "Arjit Singh"));
        playlist.add(new Playlist("Kamleya","Pankaj"));
        playlist.add(new Playlist("Tum Prem Ho", "Ram"));

        Spotify spotify = new Spotify(playlist);
        Iterator<Playlist> Iterator = spotify.createPlaylistIterator();
        Iterator<Playlist> revIterator = spotify.createReversePlaylistIterator();

        Playlist temp;
        System.out.println(Iterator.hasNext());
        temp = Iterator.next();
        temp = Iterator.next();
        System.out.println(temp.singer + " " + temp.songName);
        System.out.println(revIterator.hasNext());
        temp = revIterator.next();
        System.out.println(temp.singer + " " + temp.songName);
    }
}
