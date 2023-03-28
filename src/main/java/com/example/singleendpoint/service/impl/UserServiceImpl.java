package com.example.singleendpoint.service.impl;

import com.example.singleendpoint.mapper.UserMapper;
import com.example.singleendpoint.model.business.User;
import com.example.singleendpoint.model.entity.UserEntity;
import com.example.singleendpoint.repository.UserRepository;
import com.example.singleendpoint.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    /**
     * Saves a user in db
     * @param toSaveUser to be saved
     * @return User
     */
    @Override
    public User save(User toSaveUser) {
        var entity = userMapper.serviceToRepo(toSaveUser);
        var savedEntity = userRepository.save(entity);
        return userMapper.repoToService(savedEntity);
    }

    /**
     * Retrieving all UserEntities from db
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userMapper::repoToService).collect(Collectors.toList());
    }
}
