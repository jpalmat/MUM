package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class KafkaConsumer {

	@KafkaListener(topics="kafka_example", groupId="group_id")
	public void consume(String message) {
		System.out.println("consumed "+ message);
	}
	
	@KafkaListener(topics="kafka_example_json", groupId="group_json", containerFactory="userKafkaListenerContainerFactory")
	public void consumeJson(User user) {
		System.out.println("consumed json "+ user);
	}
}
