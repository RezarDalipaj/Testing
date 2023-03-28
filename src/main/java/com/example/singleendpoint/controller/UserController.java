package com.example.singleendpoint.controller;

import com.example.singleendpoint.config.RabbitMqConfig;
import com.example.singleendpoint.config.UserQueueProperties;
import com.example.singleendpoint.mapper.UserMapper;
import com.example.singleendpoint.model.business.User;
import com.example.singleendpoint.model.dto.UserDto;
import com.example.singleendpoint.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
@AllArgsConstructor
@Import(RabbitMqConfig.class)
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final RabbitTemplate rabbitTemplate;
    private final UserQueueProperties userQueueProperties;

    /**
     * User enters his data and they get saved in db
     *
     * @param userDto UserDto
     * @return UserDto
     */
    @PostMapping("/signup")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        var user = userMapper.controllerToService(userDto);
        var savedUser = userService.save(user);
        var response = userMapper.serviceToController(savedUser);
        rabbitTemplate.convertAndSend(userQueueProperties.getExchange(), userQueueProperties.getRoutingKey(), response);
        return ResponseEntity.ok(response);
    }

    /**
     * Lists all users from db
     *
     * @return List<UserDto>
     * no param
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.findAll();
        var response = users.stream().map(userMapper::serviceToController).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
