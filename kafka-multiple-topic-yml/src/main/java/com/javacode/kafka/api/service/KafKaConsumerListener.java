package com.javacode.kafka.api.service;

import com.javacode.kafka.api.constant.AppConstants;
import com.javacode.kafka.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumerListener.class);

    @KafkaListener(topics = {AppConstants.TOPIC_NAME1, AppConstants.TOPIC_NAME2},
            groupId = AppConstants.GROUP_ID)
    public void consume1(User data, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        LOGGER.info(String.format("Message Topic1 received -> %s", data.toString(), topic));
        System.out.println("Event on topic={}, payload={} "+ topic+", "+ data.toString());
    }

//    @KafkaListener(topics = AppConstants.TOPIC_NAME2,
//            groupId = AppConstants.GROUP_ID)
//    public void consume2(User data) {
//        LOGGER.info(String.format("Message Topic2 received -> %s", data.toString()));
//    }
}