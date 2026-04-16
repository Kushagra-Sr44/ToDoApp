package com.kushagra.todolistapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("UserDB")
@Data
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String userName;
    private String password;
    private List<String> roles;
    @DBRef
    private List<ToDo> toDoList;

}
