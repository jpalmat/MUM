package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;
import com.example.demo.service.response.CustomerResponse;

import edu.miu.common.controller.BaseReadController;

@RestController
@RequestMapping("/customers")
public class SampleController extends BaseReadController<CustomerResponse, Customer, Integer> {
	
}