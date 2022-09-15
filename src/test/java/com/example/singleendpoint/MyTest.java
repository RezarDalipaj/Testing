package com.example.singleendpoint;

import com.example.singleendpoint.integration.GivenSomeState;
import com.example.singleendpoint.integration.ThenSomeOutcome;
import com.example.singleendpoint.integration.WhenSomeAction;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.jupiter.api.Test;

public class MyTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    @Test
    public void something_should_happen() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }
}
