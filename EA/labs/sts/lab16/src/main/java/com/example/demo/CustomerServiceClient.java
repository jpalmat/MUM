package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class CustomerServiceClient {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Value("${sample-service-url}")
	private String serviceName;
	
	public List<CustomerResponse> getMovies(){
		return restTemplate.getForObject(lookupUrlFor(serviceName)+"customers?fetch-all=true", List.class);
	}
	
	private String lookupUrlFor(String appName) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
		return instanceInfo.getHomePageUrl();
	}
}