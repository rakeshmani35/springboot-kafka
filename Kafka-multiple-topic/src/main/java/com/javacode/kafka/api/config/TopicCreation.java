package com.javacode.kafka.api.config;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicCreation {
    final String[] topicNames = new String[] {"topic1", "topic2"};
    final SingletonBeanRegistry beanRegistry;

    public TopicCreation(GenericApplicationContext context) {
        this.beanRegistry = context.getBeanFactory();
    }

    @PostConstruct
    public void createTopics() {
        for (String topic : topicNames) {
            NewTopic newTopic = TopicBuilder
                    .name(topic)
                    .replicas(1)
                    .partitions(1)
                    .build();
            beanRegistry.registerSingleton("topic-" + topic, newTopic);
        }
    }
}
