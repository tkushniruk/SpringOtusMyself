package com.example.demo.shell;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellComponentService {
    private PersonServiceImpl personService;
    private Person person;

    @Autowired
    public ShellComponentService(
            PersonServiceImpl personService
    ) {
        this.personService = personService;
    }

    @ShellMethod("Input your surname and name with --name and --surname args")
    public String login(String name, String surname) {
        this.person = personService.getByFullname(name, surname);
        return String.format("Hello %s %s",person.getSurname(),person.getName());
    }
}
