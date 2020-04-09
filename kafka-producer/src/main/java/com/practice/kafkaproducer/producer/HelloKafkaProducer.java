package com.practice.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloKafkaProducer {

    private static final String TOPIC_NAME = "t_hello";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendHello(final String message){
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
