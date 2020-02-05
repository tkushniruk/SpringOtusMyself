package com.example.demo.dao;

import com.example.demo.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionsDao {
    List<Question> getQuestion() throws IOException;
}
