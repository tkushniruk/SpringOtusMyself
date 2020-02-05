package com.example.demo.dao;

import com.example.demo.domain.ApplicationFilepathSetting;
import com.example.demo.domain.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionsDaoImplTest {
    private static Question test;
    private static String[] data = {"What is 2 + 2?","one","two","three","four","4"};

    @MockBean
    QuestionsDaoImpl mockBean;

    @Before
    public void init() {
        List<String> answers = new ArrayList<>();
        answers.add("one");
        answers.add("two");
        answers.add("three");
        answers.add("four");

        mockBean = new QuestionsDaoImpl(new ApplicationFilepathSetting());
        test = new Question("What is 2 + 2?",answers,4);
    }

    @Test
    public void isDataTrulyParsed() {
        Question actual = mockBean.dataToQuestion(data);
        assertTrue(new ReflectionEquals(test,"toString()").matches(actual));
    }


    @Test
    public void isQuestionChangedWhenDataChanged() {
        data[0] = "";
        Question actual = mockBean.dataToQuestion(data);
        assertFalse(new ReflectionEquals(test,"toString()").matches(actual));
    }

}
