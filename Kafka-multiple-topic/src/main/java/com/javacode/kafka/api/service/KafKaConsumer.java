package com.javacode.kafka.api.service;

import com.javacode.kafka.api.constant.AppConstants;
import com.javacode.kafka.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME1,
            groupId = AppConstants.GROUP_ID)
    public void consume1(User data) {
        LOGGER.info(String.format("Message Topic1 received -> %s", data.toString()));
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME2,
            groupId = AppConstants.GROUP_ID)
    public void consume2(User data) {
        LOGGER.info(String.format("Message Topic2 received -> %s", data.toString()));
    }
}