package com.practice.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FixedRateKafkaProducer {

    private static final String TOPIC_NAME = "t_fixedrate";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

    @Scheduled(fixedRate = 1000)
    public void sendMessage(){
        i++;
        System.out.println("var i is " + i);
        kafkaTemplate.send(TOPIC_NAME, "Fixed rate: " + i);
    }
}
