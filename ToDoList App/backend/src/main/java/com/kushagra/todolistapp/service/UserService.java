package com.kushagra.todolistapp.service;

import com.kushagra.todolistapp.entity.User;
import com.kushagra.todolistapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
@Autowired
     private PasswordEncoder passwordEncoder ;

    public ResponseEntity<?> createUser(User user){
        if(userRepository.findByUserName(user.getUserName())!=null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        String username=user.getUserName();
        String password=user.getPassword();
        if(username==null|| password==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setRoles(new ArrayList<>(Arrays.asList("USER")));
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<?> getUser(Authentication auth){
        String username=auth.getName();
        User user=userRepository.findByUserName(username);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    public ResponseEntity<?> getAllUser(Authentication auth){
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> changeUserPassword(Authentication auth,User user){
        User olduser=userRepository.findByUserName(auth.getName());
        if(!olduser.getUserName().equals(user.getUserName())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(user.getPassword()==null ) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        olduser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(olduser);
        return new ResponseEntity<>(HttpStatus.OK);
     }
     public ResponseEntity<?> deleteUser(Authentication auth){
        String username=auth.getName();
        User user=userRepository.findByUserName(username);
        userRepository.deleteById(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
     }
}
