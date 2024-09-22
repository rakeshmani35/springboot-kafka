package com.javacode.kafka.api.service;

import com.javacode.kafka.api.config.TopicConfig;
import com.javacode.kafka.api.config.TopicCreation;
import com.javacode.kafka.api.constant.AppConstants;
import com.javacode.kafka.api.model.Topic;
import com.javacode.kafka.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private TopicConfig topics;

    public void sendMessage(User data) {
        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        kafkaTemplate.send(AppConstants.TOPIC_NAME1, data);
//        kafkaTemplate.send(AppConstants.TOPIC_NAME2, data);
    }
}
