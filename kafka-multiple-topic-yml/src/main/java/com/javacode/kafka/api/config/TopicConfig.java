package com.javacode.kafka.api.config;

import com.javacode.kafka.api.factory.YamlPropertySourceFactory;
import com.javacode.kafka.api.model.Topic;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;


@Setter
@Getter
@Component
@PropertySource(value = "classpath:topic/topic.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "topic.details")
public class TopicConfig {

    private List<Topic> topics;


//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Topic {
//
//        private String name;
//        private Integer partitions;
//        private Integer replicas;
//    }
}
