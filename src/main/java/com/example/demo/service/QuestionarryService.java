package com.example.demo.service;

import com.example.demo.domain.Question;

public interface QuestionarryService {
    int askQuestion(Question question);
    boolean checkQuestion(Question question, int answer);
}
