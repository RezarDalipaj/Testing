package com.example.singleendpoint;

import com.example.singleendpoint.config.UserQueueProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({UserQueueProperties.class})
public class SingleEndpointApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleEndpointApplication.class, args);
    }

}
