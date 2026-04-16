package com.kushagra.todolistapp.Controller;

import com.kushagra.todolistapp.entity.ToDo;
import com.kushagra.todolistapp.service.ToDoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @GetMapping("/getalltodo")
    public ResponseEntity<?> getAllToDo(Authentication auth){
        return toDoService.getAllToDo(auth);
    }
    @GetMapping("/getbyid{id}")
    public ResponseEntity<?> getToDo(Authentication auth,@PathVariable ObjectId id){
        return toDoService.getToDo(auth,id);
    }
    @PostMapping
    public ResponseEntity<?> createToDo(Authentication auth ,@RequestBody ToDo toDo){
        return toDoService.createToDo(auth,toDo);
    }
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteById(Authentication auth,@PathVariable String id){
        ObjectId objectId=new ObjectId(id);
        return toDoService.deleteById(auth,objectId);
    }
    @PutMapping("/changetodobyid{id}")
    public ResponseEntity<?> editToDoById(Authentication auth,@PathVariable ObjectId id,@RequestBody ToDo toDo){
        return toDoService.editToDoById(auth,id,toDo);
    }
    @GetMapping("/status/{status}/{id}")
    public ResponseEntity<?> editStatus(Authentication auth,@PathVariable String id,@PathVariable  String status){
        ObjectId oid=new ObjectId(id);
        return toDoService.editStatus(auth,oid,status);
    }


}
