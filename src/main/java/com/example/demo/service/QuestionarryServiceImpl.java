package com.example.demo.service;

import com.example.demo.dao.QuestionsDaoImpl;
import com.example.demo.domain.Question;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionarryServiceImpl {
    private QuestionsDaoImpl questionsDao;

    public QuestionarryServiceImpl(QuestionsDaoImpl questionsDao) {
        this.questionsDao = questionsDao;
    }

    public void askQuestion(Question question) {
        System.out.println("Answer the question");
        System.out.println(question.getQuestion());
        int index = 1;
        System.out.println("Choose your answer");
        for(String answer : question.getAnswers()) {
            System.out.println(((index) + ")" + answer));
            index++;
        }
    }

    public int getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public boolean checkQuestion(Question question, int answer) {
        return question.checkAnswer(answer);
    }

    public int doTheTest() {
        int result = 0;
        try {
            List<Question> test = questionsDao.getQuestion();
            for(Question q: test) {
                askQuestion(q);
                int answer = getAnswer();
                if(checkQuestion(q, answer)) {
                    result += 10;
                }
            }
        }catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
