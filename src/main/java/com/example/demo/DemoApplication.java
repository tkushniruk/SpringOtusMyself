package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    /*public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        PersonServiceImpl personService = context.getBean(PersonServiceImpl.class);
        QuestionarryServiceImpl questionarryService = context.getBean(QuestionarryServiceImpl.class);

        String name = askName();
        String surname = askSurname();

        Person person = personService.getByFullname(name, surname);
        int result = questionarryService.doTheTest();
        System.out.println(person.getName() + " " + person.getSurname() + ". Your result is: " + result + " points.");

    }

    private static String askName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your name?");
        return sc.nextLine();
    }

    private static String askSurname() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your surname?");
        return sc.nextLine();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
