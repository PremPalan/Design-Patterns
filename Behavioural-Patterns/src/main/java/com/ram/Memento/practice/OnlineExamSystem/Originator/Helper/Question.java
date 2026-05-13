package com.ram.Memento.practice.OnlineExamSystem.Originator.Helper;


public class Question {
    private final String question;
    private Options option = Options.DEFAULT;

    public Question(String question){
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }
}
