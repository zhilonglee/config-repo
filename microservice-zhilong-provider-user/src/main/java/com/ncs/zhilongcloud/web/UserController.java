package com.ncs.zhilongcloud.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.zhilongcloud.entity.User;
import com.ncs.zhilongcloud.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/eureka-service")
	public String serviceUrl(){
		InstanceInfo nextServerFromEureka = this.eurekaClient.getNextServerFromEureka("microservice-zhilong-provider-user", false);
		return nextServerFromEureka.getHomePageUrl();
	}
	
	@GetMapping("/discovery-service")
	public ServiceInstance servicediscoveryUrl(){
		return this.discoveryClient.getLocalServiceInstance();
	}
	
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return userService.findById(id);
	}
	
	@PostMapping("/user")
	public User postUserTest(@RequestBody User user){
		return user;
	}

	@GetMapping("/list-all")
	public List<User> listAll(){
		List<User> list = new ArrayList<>();
		User user1 = new User();
		user1.setId(11l);
		user1.setName("caichao");
		list.add(user1);
		User user2 = new User();
		user2.setId(12l);
		user2.setName("chaocai");
		list.add(user2);
		User user3 = new User();
		user3.setId(13l);
		user3.setName("lubandashi");
		list.add(user3);
		return list;
	}
}
