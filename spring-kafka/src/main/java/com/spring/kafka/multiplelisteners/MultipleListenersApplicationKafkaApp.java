package com.spring.kafka.multiplelisteners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = { KafkaTopicConfig.class, KafkaConsumerConfig_MultipleListeners.class, KafkaProducerConfig_MultipleListeners.class })
public class MultipleListenersApplicationKafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(MultipleListenersApplicationKafkaApp.class, args);
    }
}
