package com.practice.kafkaconsumer.consumer;

import com.practice.kafkaconsumer.handler.HandlerExceptionTopicHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HandleExceptionKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(HandleExceptionKafkaConsumer.class);

    private static final String TOPIC_NAME = "t_handle_exceptions";

    @KafkaListener(topics = TOPIC_NAME, errorHandler = "handlerExceptionTopicErrorHandler")
    public void consume(final Integer message){

        if (message > 990) {
            throw new IllegalArgumentException("Message is invalid: " + message);
        }

        LOG.info("Message from producer: {}", message);
    }
}
