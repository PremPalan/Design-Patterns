package com.ram.Memento.practice.OnlineExamSystem.CareTaker;

import com.ram.Memento.practice.OnlineExamSystem.Memento.Memento;

import java.util.Stack;

public class AutoSaveManager {

    private final Stack<Memento> snapshots;

    private static final int MAX_HISTORY = 5;

    public AutoSaveManager() {
        this.snapshots = new Stack<>();
    }

    public void save(Memento memento) {

        if (snapshots.size() == MAX_HISTORY) {

            snapshots.remove(0);
        }

        snapshots.push(memento);

        System.out.println("Auto-save completed");
    }

    public Memento restoreLatest() {

        if (snapshots.isEmpty()) {

            System.out.println("No snapshots found");

            return null;
        }

        return snapshots.peek();
    }

    public void showHistorySize() {

        System.out.println("Snapshots Stored : "
                + snapshots.size());
    }
}