package com.spring.kafka.multipletopics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentTopicCreation {

    @Autowired
    private TopicConfig topicConfig;

    @Bean
    public KafkaAdmin.NewTopics createKafkaTopics() {
        System.out.println(topicConfig.getPaymentTopics());
        List<NewTopic> topics = new ArrayList<>();

        topicConfig.getPaymentTopics().forEach(topic ->
                topics.add(TopicBuilder.name(topic.getName())
                        .partitions(topic.getPartitions())
                        .replicas(topic.getReplicas()).build()));

        return new KafkaAdmin.NewTopics(topics.toArray(NewTopic[]::new));
    }

}
