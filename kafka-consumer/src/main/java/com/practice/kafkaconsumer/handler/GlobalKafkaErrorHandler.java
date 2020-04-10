package com.practice.kafkaconsumer.handler;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class GlobalKafkaErrorHandler implements ConsumerAwareErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalKafkaErrorHandler.class);

    @Override
    public void handle(Exception e, ConsumerRecord<?, ?> consumerRecord, Consumer<?, ?> consumer) {
        LOG.error("Global Error. Message: {} - Error: {}", consumerRecord.value(), e.getMessage());
    }
}
