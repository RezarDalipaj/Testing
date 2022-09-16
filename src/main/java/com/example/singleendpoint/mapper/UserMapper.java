package com.example.singleendpoint.mapper;

import com.example.singleendpoint.model.business.User;
import com.example.singleendpoint.model.entity.UserEntity;
import openapi.models.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Controller layer to business layer
     *
     * @param userDto
     * @return User
     */
    User controllerToService(openapi.models.UserDto userDto);

    /**
     * Business layer to controller layer
     *
     * @param user
     * @return UserDto
     */
    UserDto serviceToController(User user);

    /**
     * Business layer to db layer
     *
     * @param user
     * @return UserEntity
     */
    UserEntity serviceToRepo(User user);

    /**
     * Db layer to business layer
     *
     * @param user
     * @return User
     */
    User repoToService(UserEntity user);
}
