package com.ram.Memento.practice.OnlineExamSystem.Originator;

import com.ram.Memento.practice.OnlineExamSystem.Memento.Memento;
import com.ram.Memento.practice.OnlineExamSystem.Originator.Helper.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ExamSession {

    private final String studentName;
    private List<Question> questionList;
    private final List<Boolean> selectedQuestions;

    private int currentIndex = 0;

    private Timer timer = new Timer();

    private long endTimeMillis;

    public ExamSession(String studentName,
                       List<Question> questionList,
                       long durationMillis) {

        this.studentName = studentName;
        this.questionList = questionList;

        this.selectedQuestions =
                new ArrayList<>(Collections.nCopies(questionList.size(), false));

        this.endTimeMillis = System.currentTimeMillis() + durationMillis;

        startTimer(durationMillis);
    }

    private void startTimer(long durationMillis) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Exam Ended");
            }
        }, durationMillis);
    }

    public void answerQuestion(int index) {
        selectedQuestions.set(index, true);
    }

    public Memento saveProgress() {

        long remainingTime = endTimeMillis - System.currentTimeMillis();

        if (remainingTime < 0) {
            remainingTime = 0;
        }

        return new Memento(
                this.studentName,
                new ArrayList<>(this.selectedQuestions),
                this.currentIndex,
                remainingTime
        );
    }

    public void restoreProgress(Memento memento) {

        this.currentIndex = memento.getCurrentIndex();

        this.selectedQuestions.clear();
        this.selectedQuestions.addAll(memento.getSelectedQuestions());

        timer.cancel();

        timer = new Timer();

        long remainingTime = memento.getRemainingTime();

        this.endTimeMillis = System.currentTimeMillis() + remainingTime;

        startTimer(remainingTime);
    }

    public void displayProgress() {

        System.out.println("Student : " + studentName);

        System.out.println("Current Question Index : " + currentIndex);

        System.out.println("Selected Questions : " + selectedQuestions);

        long remainingTime = endTimeMillis - System.currentTimeMillis();

        System.out.println("Remaining Time : "
                + (remainingTime / 1000) + " seconds");

        System.out.println();
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}