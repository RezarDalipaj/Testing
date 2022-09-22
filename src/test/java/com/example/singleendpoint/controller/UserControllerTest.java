package com.example.singleendpoint.controller;

import com.example.singleendpoint.config.JGivenConfig;
import com.example.singleendpoint.config.MockRabbitMqConfig;
import com.example.singleendpoint.integration.GivenSomeState;
import com.example.singleendpoint.integration.ThenSomeOutcome;
import com.example.singleendpoint.integration.WhenSomeAction;
import com.tngtech.jgiven.integration.spring.junit5.SpringScenarioTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;


@Import({JGivenConfig.class, MockRabbitMqConfig.class})
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest extends SpringScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    @Test
    void something_should_happen() throws Exception {
        given().user_exist_in_db();
        when().a_$_request(HttpMethod.GET, "/users")
                .and()
                .is_sent();
        then().status_ok();
    }
}
