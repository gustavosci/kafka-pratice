package com.practice.kafkaconsumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloKafkaConsumer {

    private static final String TOPIC_NAME = "t_hello";

    @KafkaListener(topics = TOPIC_NAME)
    public void consume(final String message){
        System.out.println("Message from producer: " + message);
    }
}
