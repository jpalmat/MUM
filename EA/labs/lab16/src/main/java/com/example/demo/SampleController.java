package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@Autowired
	private CustomerServiceClient service;
	
	@GetMapping("customers")
	public List<CustomerResponse> getCustomer(){
		return service.getMovies();
	}
}
