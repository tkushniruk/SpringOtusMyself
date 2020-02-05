package com.example.demo.domain;

import java.util.List;

public class Question {
    private String question;
    private List<String> answers;
    private int indexOfTrueQuestion;

    public Question(String question, List<String> answers, int indexOfTrueQuestion) {
        this.question = question;
        this.answers = answers;
        this.indexOfTrueQuestion = indexOfTrueQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public boolean checkAnswer(int index) {
        return index == indexOfTrueQuestion;
    }
}
