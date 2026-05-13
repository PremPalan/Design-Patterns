package com.ram.Memento.practice.OnlineExamSystem;

import com.ram.Memento.practice.OnlineExamSystem.CareTaker.AutoSaveManager;
import com.ram.Memento.practice.OnlineExamSystem.Memento.Memento;
import com.ram.Memento.practice.OnlineExamSystem.Originator.ExamSession;
import com.ram.Memento.practice.OnlineExamSystem.Originator.Helper.Question;

import java.util.ArrayList;
import java.util.List;

public class OnlineExamSystem {
    public static void main(String[] args)
            throws InterruptedException {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is Java?"));
        questions.add(new Question("What is OOP?"));
        questions.add(new Question("What is JVM?"));

        ExamSession examSession =
                new ExamSession(
                        "Ram",
                        questions,
                        30000
                );

        AutoSaveManager autoSaveManager =
                new AutoSaveManager();

        System.out.println("===== Initial State =====");

        examSession.displayProgress();

        // Student answers question 1
        examSession.answerQuestion(0);

        examSession.setCurrentIndex(1);

        autoSaveManager.save(examSession.saveProgress());

        Thread.sleep(2000);

        // Student answers question 2
        examSession.answerQuestion(1);

        examSession.setCurrentIndex(2);

        autoSaveManager.save(examSession.saveProgress());

        System.out.println("===== Current State =====");

        examSession.displayProgress();

        // Simulate crash
        System.out.println("===== Simulating Crash =====");

        Thread.sleep(2000);

        // Restore latest snapshot
        Memento latest =
                autoSaveManager.restoreLatest();

        if (latest != null) {

            examSession.restoreProgress(latest);
        }

        System.out.println("===== Restored State =====");

        examSession.displayProgress();

        autoSaveManager.showHistorySize();
    }
}
