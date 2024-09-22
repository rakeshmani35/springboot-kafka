package com.javacode.kafka.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Topic {

    private String name;
    private Integer partitions;
    private Integer replicas;
}
