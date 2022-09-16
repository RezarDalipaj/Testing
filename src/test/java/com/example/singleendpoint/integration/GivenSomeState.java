package com.example.singleendpoint.integration;

import com.example.singleendpoint.repository.UserRepository;
import com.example.singleendpoint.testutils.UserFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class GivenSomeState extends Stage<GivenSomeState> {
    @Autowired
    private UserRepository userRepository;

    public GivenSomeState user_exist_in_db() {
        var user = UserFactory.createUserEntity();
        userRepository.save(user);
        return self();
    }
}
