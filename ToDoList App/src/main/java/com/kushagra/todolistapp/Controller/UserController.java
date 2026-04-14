package com.kushagra.todolistapp.Controller;

import com.kushagra.todolistapp.entity.User;
import com.kushagra.todolistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<?> getUser(Authentication auth){
        return userService.getUser(auth);
    }
    @GetMapping("/getalluser")
    public ResponseEntity<?> getAllUser(Authentication auth){
        return userService.getAllUser(auth);
    }
    @PutMapping
    public ResponseEntity<?> changeUserPassword(Authentication auth,@RequestBody User user){
        return userService.changeUserPassword(auth,user);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUser(Authentication auth){
        return userService.deleteUser(auth);
    }
}
