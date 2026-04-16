package com.kushagra.todolistapp.repository;

import com.kushagra.todolistapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    public User findByUserName(String userName);
}
