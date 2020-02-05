package com.example.demo.service;

import com.example.demo.domain.Person;

public interface PersonService {
    Person getByFullname(String name, String surname);
}
