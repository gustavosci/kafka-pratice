package com.practice.kafkaconsumer.handler;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component(value = "handlerExceptionTopicErrorHandler")
public class HandlerExceptionTopicHandler implements ConsumerAwareListenerErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerExceptionTopicHandler.class);

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e, Consumer<?, ?> consumer) {
        LOG.error("Error from topic t_handle_exception. Message: {} - Error: {}", message.getPayload(), e.getMessage());
        return null;
    }
}
