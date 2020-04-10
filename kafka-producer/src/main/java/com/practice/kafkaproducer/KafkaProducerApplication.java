package com.practice.kafkaproducer;

import com.practice.kafkaproducer.producer.MultiPartitionsKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private MultiPartitionsKafkaProducer multiPartitionsKafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 1000; i++){
			var key = "key-" + (i % 4);
			var value = "data " + i + " with key " + key;
			multiPartitionsKafkaProducer.sendMessage(key, value);
		}
	}
}
