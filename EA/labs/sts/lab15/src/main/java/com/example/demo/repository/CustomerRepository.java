package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Customer;

import edu.miu.common.repository.BaseRepository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Integer>{

}
