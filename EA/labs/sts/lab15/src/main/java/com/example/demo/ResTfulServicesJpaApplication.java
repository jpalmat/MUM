package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "edu.miu.common, com.example.demo")
public class ResTfulServicesJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulServicesJpaApplication.class, args);
	}

}
