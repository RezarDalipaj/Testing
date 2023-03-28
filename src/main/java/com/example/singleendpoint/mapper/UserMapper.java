package com.example.singleendpoint.mapper;

import com.example.singleendpoint.model.business.User;
import com.example.singleendpoint.model.dto.UserDto;
import com.example.singleendpoint.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Controller layer to business layer
     *
     * @param userDto UserDto
     * @return UserDto
     */
    User controllerToService(UserDto userDto);

    /**
     * Business layer to controller layer
     *
     * @param user User
     * @return User
     */
    UserDto serviceToController(User user);

    /**
     * Business layer to db layer
     *
     * @param user User
     * @return UserEntity
     */
    UserEntity serviceToRepo(User user);

    /**
     * Db layer to business layer
     *
     * @param user UserEntity
     * @return User
     */
    User repoToService(UserEntity user);
}
