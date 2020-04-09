package com.practice.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MultiPartitionsKafkaProducer {

    private static final String TOPIC_NAME = "t_multi_partitions";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String key, final String value){
        kafkaTemplate.send(TOPIC_NAME, key, value);
    }
}
