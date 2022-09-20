package com.example.singleendpoint.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Field
    private Integer id;
    @Field
    private String userName;
    @Field
    private String password;
    @Field
    private Double balance;
    @Field
    private String address;
}
