package com.kushagra.todolistapp.service;

import com.kushagra.todolistapp.entity.ToDo;
import com.kushagra.todolistapp.entity.User;
import com.kushagra.todolistapp.repository.ToDoRepository;
import com.kushagra.todolistapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.AotInitializerNotFoundException;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<?> getAllToDo(Authentication auth){
        String username=auth.getName();
        User user=userRepository.findByUserName(username);
        if(user.getToDoList()==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(user.getToDoList(),HttpStatus.OK);
    }
    public ResponseEntity<?> getToDo(Authentication auth, ObjectId id){
        User user=userRepository.findByUserName(auth.getName());
        ToDo toDo=toDoRepository.findByid(id);
        if(toDo==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(toDo,HttpStatus.OK);
    }
    public ResponseEntity<?> createToDo(Authentication auth,ToDo toDo){
       User user=userRepository.findByUserName(auth.getName());
       toDoRepository.save(toDo);
       ToDo toDo1=toDoRepository.findByid(new ObjectId(toDo.getId()));
       if(user.getToDoList()==null){
           user.setToDoList(new ArrayList<>());
       }
//       user.setToDoList();
       user.getToDoList().add(toDo1);
       userRepository.save(user);
       return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<?> editToDoById(Authentication auth,ObjectId id,ToDo toDo){
        ToDo newToDo =toDoRepository.findByid(id);
        newToDo.setTitle(toDo.getTitle());
        newToDo.setContent(toDo.getContent());
        User user=userRepository.findByUserName(auth.getName());

        toDoRepository.save(newToDo);
//        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<?> deleteById(Authentication auth,ObjectId id){
        User user=userRepository.findByUserName(auth.getName());
       ToDo toDo= toDoRepository.findByid(id);
        user.getToDoList().remove(toDo);
        userRepository.save(user);
        toDoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
