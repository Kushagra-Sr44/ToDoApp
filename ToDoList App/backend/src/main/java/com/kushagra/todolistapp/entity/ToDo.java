package com.kushagra.todolistapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ToDoDB")
@Data
@NoArgsConstructor
public class ToDo {

    @Id
    private ObjectId id;

    private String title;
    private String content;
    private String status ="Default";
    public String getId() {
        return id != null ? id.toHexString() : null;
    }

}