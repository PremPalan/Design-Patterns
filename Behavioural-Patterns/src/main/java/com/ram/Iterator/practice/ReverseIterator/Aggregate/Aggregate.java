package com.ram.Iterator.practice.ReverseIterator.Aggregate;


import com.ram.Iterator.practice.ReverseIterator.Iterator.Iterator;

public interface Aggregate<T> {
    Iterator<T> createPlaylistIterator();
    Iterator<T> createReversePlaylistIterator();
}
