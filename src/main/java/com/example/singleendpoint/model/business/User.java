package com.example.singleendpoint.model.business;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Double balance;
    private String address;
}
