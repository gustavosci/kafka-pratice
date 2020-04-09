package com.practice.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MultiPartitionsKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MultiPartitionsKafkaConsumer.class);

    private static final String TOPIC_NAME = "t_multi_partitions";

    @KafkaListener(topics = TOPIC_NAME, concurrency = "3") // if we define more consumers than partitions, spring will handle it and make the rest consumers idle
    public void consume(final ConsumerRecord<String, String> message){
        LOG.info("Message from producer: Key {} - Value {} - Topic {} - Partition {} ", message.key(), message.value(), message.topic(), message.partition());
    }
}
