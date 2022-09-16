package com.example.singleendpoint.integration;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@JGivenStage
public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
    @ScenarioState
    private ResultActions requestResult;
    public ThenSomeOutcome status_ok() throws Exception {
        assertThat(requestResult.andExpect(status().isOk()));
        return self();
    }
}
