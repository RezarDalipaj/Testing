package com.example.singleendpoint.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private Double balance;
}
