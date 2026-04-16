package com.kushagra.todolistapp.repository;

import com.kushagra.todolistapp.entity.ToDo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ToDoRepository extends MongoRepository<ToDo, ObjectId> {
    ToDo findByid(ObjectId id);
}
