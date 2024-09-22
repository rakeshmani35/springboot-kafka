package com.spring.kafka;

import com.spring.kafka.multipletopics.KafkaMultipleTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaMultipleTopicsApplication implements CommandLineRunner {

    @Autowired
    private KafkaMultipleTopicService multipleTopicService;

    @Override
    public void run(String... args) throws Exception {
        String message = multipleTopicService.sendMessage();
        System.out.println(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaMultipleTopicsApplication.class, args);
    }

}
