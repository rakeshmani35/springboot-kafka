package com.javacode.kafka.api.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private static final String TOPIC_NAME = "topic1";

    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name(TOPIC_NAME)
                .build();
    }
}
