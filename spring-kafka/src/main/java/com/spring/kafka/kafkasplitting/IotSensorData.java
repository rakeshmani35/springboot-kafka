package com.spring.kafka.kafkasplitting;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IotSensorData {
    private String sensorType;
    private String value;
    private String sensorId;

}
