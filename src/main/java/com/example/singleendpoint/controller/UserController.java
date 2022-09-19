package com.example.singleendpoint.controller;

import com.example.singleendpoint.mapper.UserMapper;
import com.example.singleendpoint.model.business.User;
import com.example.singleendpoint.model.dto.UserDto;
import com.example.singleendpoint.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    /**
     * User enters his data and they get saved in db
     *
     * @param userDto
     * @return UserDto
     */
    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        var user = userMapper.controllerToService(userDto);
        var savedUser = userService.save(user);
        var response = userMapper.serviceToController(savedUser);
        return ResponseEntity.ok(response);
    }

    /**
     * Lists all users from db
     *
     * @return List<UserDto>
     * no param
     */
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.findAll();
        var response = users.stream().map(userMapper::serviceToController).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
