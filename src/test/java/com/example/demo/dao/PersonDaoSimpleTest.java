package com.example.demo.dao;

import com.example.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDaoSimpleTest {
    private String name;
    private String surname;
    private Person test;

    @MockBean
    PersonDaoSimple actual;

    @Before
    public void init() {
        actual = new PersonDaoSimple();
        name = "testName";
        surname = "testSurname";
        test = new Person(name,surname);
    }

    @Test
    public void isTrulyCreated() {
        Person actual = this.actual.createPerson(name,surname);
        assertTrue(new ReflectionEquals(test, "toString()").matches(actual));
    }

    @Test
    public void isFalseEqualsWhenDifferentData() {
        Person actual = this.actual.createPerson(name,name);
        assertFalse(new ReflectionEquals(test, "toString()").matches(actual));
    }
}
