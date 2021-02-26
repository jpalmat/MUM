package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.service.response.CustomerResponse;

import edu.miu.common.service.BaseReadService;

public interface CustomerService extends BaseReadService<CustomerResponse, Customer, Integer> {

}
