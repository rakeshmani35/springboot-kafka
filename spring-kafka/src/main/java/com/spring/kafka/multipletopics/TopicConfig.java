package com.spring.kafka.multipletopics;

import com.spring.kafka.factory.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;


@Setter
@Getter
@Component
@PropertySource(value = "classpath:payments/payment.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "payments.topic.details")
public class TopicConfig {

    private List<PaymentTopic> paymentTopics;


    @Setter
    @Getter
    @ToString
    public static class PaymentTopic {

        private String name;
        private Integer partitions;
        private Integer replicas;
    }
}
