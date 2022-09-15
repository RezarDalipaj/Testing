package com.example.singleendpoint.integration;

import com.tngtech.jgiven.Stage;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class WhenSomeAction extends Stage<WhenSomeAction> {

    private MockMvc mockMvc;
    private MockMvcRequestBuilders requestBuilder;

    public WhenSomeAction request_is(String url) {
        requestBuilder = MockMvcRequestBuilders.request()
    }

    public WhenSomeAction request_is_sent() throws Exception {
        this.mockMvc.perform(requestBuilder);
        return self();
    }
}
