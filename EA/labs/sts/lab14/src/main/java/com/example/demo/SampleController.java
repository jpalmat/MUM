package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	CustomerRepository cRepository;

	@RequestMapping(value="/customers")
	public List<Customer> getCustomer(){
		return cRepository.findAll();
	}
}
