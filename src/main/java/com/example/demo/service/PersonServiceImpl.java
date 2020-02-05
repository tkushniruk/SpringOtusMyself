package com.example.demo.service;

import com.example.demo.dao.PersonDaoSimple;
import com.example.demo.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDaoSimple dao;

    public PersonServiceImpl(PersonDaoSimple dao) {
        this.dao = dao;
    }

    @Override
    public Person getByFullname(String name, String surname) {
        return dao.createPerson(name, surname);
    }
}
