package com.example.demo.dao;

import com.example.demo.domain.Person;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDaoSimple {
    public Person createPerson(String name, String surname) {
        return new Person(name, surname);
    }
}
