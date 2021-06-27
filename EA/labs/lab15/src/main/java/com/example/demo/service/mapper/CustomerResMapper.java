package com.example.demo.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Customer;
import com.example.demo.service.response.CustomerResponse;

import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;

@Component
public class CustomerResMapper extends BaseMapper<Customer, CustomerResponse> {

	@Autowired
	public CustomerResMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Customer.class, CustomerResponse.class);
		// TODO Auto-generated constructor stub
	}

}
