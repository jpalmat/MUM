package com.example.demo.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	@GetMapping("public/{name}")
	public String post(@PathVariable("name") final String name) {
		kafkaTemplate.send("kafka_example" , new User(name, "MUM", 100000L));
		return "publish succesfully";
	}
	
	@GetMapping("publicJson/{name}")
	public String postUser(@PathVariable("name") final String name) {
		kafkaTemplate.send("kafka_example_json" , new User(name, "MUM", 100000L));
		return "publish succesfully";
	}
}
