package com.kushagra.todolistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ToDoListAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(ToDoListAppApplication.class, args);
    }

}
