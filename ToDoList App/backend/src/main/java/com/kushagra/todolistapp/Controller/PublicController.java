package com.kushagra.todolistapp.Controller;

import com.kushagra.todolistapp.entity.User;
import com.kushagra.todolistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
