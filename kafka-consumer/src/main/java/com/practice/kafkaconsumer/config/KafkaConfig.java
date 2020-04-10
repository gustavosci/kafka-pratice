package com.practice.kafkaconsumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        var props = kafkaProperties.buildConsumerProperties();
        props.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "10000");
        return new DefaultKafkaConsumerFactory<>(props);
    }
}