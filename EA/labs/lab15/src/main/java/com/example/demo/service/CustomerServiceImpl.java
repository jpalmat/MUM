package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Customer;
import com.example.demo.service.response.CustomerResponse;

import edu.miu.common.service.BaseReadServiceImpl;

@Service
@Transactional
public class CustomerServiceImpl extends BaseReadServiceImpl<CustomerResponse, Customer, Integer> implements CustomerService {

}
