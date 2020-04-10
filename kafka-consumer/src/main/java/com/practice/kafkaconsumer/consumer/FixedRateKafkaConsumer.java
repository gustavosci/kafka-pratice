package com.practice.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRateKafkaConsumer {

    private static final String TOPIC_NAME = "t_fixedrate";

    @KafkaListener(topics = TOPIC_NAME, groupId = "specific_group_fixed_rate")
    public void consume(final String message){
        System.out.println("Message from producer: " + message);
    }
}
