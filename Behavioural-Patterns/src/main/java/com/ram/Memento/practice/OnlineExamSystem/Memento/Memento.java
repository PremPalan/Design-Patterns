package com.ram.Memento.practice.OnlineExamSystem.Memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private final String studentName;

    private final List<Boolean> selectedQuestions;

    private final int currentIndex;

    private final long remainingTime;

    public Memento(String studentName,
                   List<Boolean> selectedQuestions,
                   int currentIndex,
                   long remainingTime) {

        this.studentName = studentName;

        this.selectedQuestions =
                new ArrayList<>(selectedQuestions);

        this.currentIndex = currentIndex;

        this.remainingTime = remainingTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Boolean> getSelectedQuestions() {
        return selectedQuestions;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public long getRemainingTime() {
        return remainingTime;
    }
}