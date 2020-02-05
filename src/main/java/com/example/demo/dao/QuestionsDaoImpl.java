package com.example.demo.dao;

import com.example.demo.domain.ApplicationFilepathSetting;
import com.example.demo.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class QuestionsDaoImpl {
    private String filePath;
    @Autowired
    public QuestionsDaoImpl(ApplicationFilepathSetting setting) {
        this.filePath = setting.getFilePath();
    }

    public List<Question> getQuestion() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
        List<Question> questions = new ArrayList<>();
        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            questions.add(dataToQuestion(data));
        }
        csvReader.close();

        return questions;
    }

    public Question dataToQuestion(String[] data) {
        List<String> answers = new ArrayList<>();
        for(int i = 1; i < data.length - 1; i++) {
            answers.add(data[i]);
        }

        return new Question(data[0], answers, Integer.parseInt(data[data.length - 1]));
    }
}
