package com.spring.kafka.multipletopics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class KafkaMultipleTopicService {

    private static final String CARD_PAYMENTS_TOPIC = "card-payments";
    private static final String BANK_TRANSFERS_TOPIC = "bank-transfers";

    @Autowired
    private KafkaTemplate<String, PaymentData> kafkaTemplate;

    public String sendMessage() {
        kafkaTemplate.send(CARD_PAYMENTS_TOPIC, createCardPayment());
        kafkaTemplate.send(BANK_TRANSFERS_TOPIC, createBankTransfer());

        return "Message Sent succefully to  topics: " + CARD_PAYMENTS_TOPIC + ", " + BANK_TRANSFERS_TOPIC;
    }

    private PaymentData createCardPayment() {
        PaymentData cardPayment = new PaymentData();
        cardPayment.setAmount(BigDecimal.valueOf(275));
        cardPayment.setPaymentReference("A184028KM0013790");
        cardPayment.setCurrency(Currency.getInstance("GBP"));
        cardPayment.setType("card");
        return cardPayment;
    }

    private PaymentData createBankTransfer() {
        PaymentData bankTransfer = new PaymentData();
        bankTransfer.setAmount(BigDecimal.valueOf(150));
        bankTransfer.setPaymentReference("19ae2-18mk73-009");
        bankTransfer.setCurrency(Currency.getInstance("EUR"));
        bankTransfer.setType("bank");
        return bankTransfer;
    }

}
