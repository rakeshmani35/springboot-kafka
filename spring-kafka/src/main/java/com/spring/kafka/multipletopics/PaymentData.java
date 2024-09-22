package com.spring.kafka.multipletopics;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.StringJoiner;

@Setter
@Getter
public class PaymentData {
    private String paymentReference;
    private String type;
    private BigDecimal amount;
    private Currency currency;

    @Override
    public String toString() {
        return new StringJoiner(", ", PaymentData.class.getSimpleName() + "[", "]")
          .add("paymentReference='" + paymentReference + "'")
          .add("type='" + type + "'")
          .add("amount=" + amount)
          .add("currency=" + currency)
          .toString();
    }
}