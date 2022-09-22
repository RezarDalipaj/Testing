package com.example.singleendpoint.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("rabbitmq.user")
public class UserQueueProperties {
    private String queue;
    private String exchange;
    private String routingKey;
}
