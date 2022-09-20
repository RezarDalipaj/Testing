package com.example.singleendpoint.integration;

import com.example.singleendpoint.repository.UserRepository;
import com.example.singleendpoint.testutils.UserFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

@JGivenStage
public class GivenSomeState extends Stage<GivenSomeState> {
    @Autowired
    private MongoTemplate mongoTemplate;

    public GivenSomeState user_exist_in_db() {
        var user = UserFactory.createUserEntity();
        mongoTemplate.save(user);
        return self();
    }
}
