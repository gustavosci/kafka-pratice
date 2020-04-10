package com.practice.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HandleExceptionKafkaProducer {

    private static final String TOPIC_NAME = "t_handle_exceptions";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final Integer message){
        kafkaTemplate.send(TOPIC_NAME, String.valueOf(message));
    }
}
