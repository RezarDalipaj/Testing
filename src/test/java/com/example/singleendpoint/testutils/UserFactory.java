package com.example.singleendpoint.testutils;

import com.example.singleendpoint.model.entity.UserEntity;

public class UserFactory {

    public static UserEntity createUserEntity(){
        return UserEntity.builder()
                .id(1)
                .userName("Test")
                .password("pass")
                .balance(123d)
                .build();
    }
}
