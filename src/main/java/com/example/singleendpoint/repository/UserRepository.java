package com.example.singleendpoint.repository;

import com.example.singleendpoint.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    /**
     * Queries the db for users with a certain username
     * @param username
     * @return UserEntity
     */
    UserEntity findUserByUserName(String username);
}
