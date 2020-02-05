package com.example.demo.service;

import com.example.demo.dao.QuestionsDaoImpl;
import com.example.demo.domain.ApplicationFilepathSetting;
import com.example.demo.domain.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionarryServiceTest {
    private static Question test;
    private static String[] data = {"What is 2 + 2?","one","two","three","four","4"};

    @MockBean
    QuestionarryServiceImpl service;

    @Autowired
    QuestionsDaoImpl questionsDao;

    @Before
    public void init() {
        List<String> answers = new ArrayList<>();
        answers.add("one");
        answers.add("two");
        answers.add("three");
        answers.add("four");

        test = new Question("What is 2 + 2?",answers,4);
        questionsDao = new QuestionsDaoImpl(new ApplicationFilepathSetting());
        service = new QuestionarryServiceImpl(questionsDao);
    }

    @Test
    public void isTrulyCheckAnswer() {
        assertTrue(service.checkQuestion(test,4));
    }

    @Test
    public void isTrulyFalseWhenWrongAnswer() {
        assertFalse(service.checkQuestion(test, 2));
    }


}
