package com.example.singleendpoint.repository;

import com.example.singleendpoint.model.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Integer> {
    /**
     * Queries the db for users with a certain username
     * @param username
     * @return UserEntity
     */
    UserEntity findUserByUserName(String username);
}
