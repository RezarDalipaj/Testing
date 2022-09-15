package com.example.singleendpoint.service;

import com.example.singleendpoint.model.business.User;

import java.util.List;

public interface UserService {

    /**
     * Saving a user to db
     * @param user to be saved
     * @return User
     */
    User save(User user);
    List<User> findAll();
}
