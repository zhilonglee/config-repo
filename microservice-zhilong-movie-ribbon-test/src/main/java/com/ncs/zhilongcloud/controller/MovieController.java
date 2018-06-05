package com.ncs.zhilongcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.zhilongcloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://microservice-zhilong-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/test")
	public String test(){
		ServiceInstance choose = loadBalancerClient.choose("microservice-zhilong-provider-user");
		
		return choose.getHost() + ":" + choose.getPort() + ":" + choose.getServiceId();
	}
	
	@GetMapping("/list-all")
	public List<User> listAll(){
		List<User> list = this.restTemplate.getForObject("http://microservice-zhilong-provider-user/list-all", List.class);
		return list;
	}
}
