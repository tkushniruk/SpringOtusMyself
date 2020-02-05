package com.example.demo.dao;

import com.example.demo.domain.Person;

public interface PersonDao {
    Person createPerson(String name, String surname);
}
