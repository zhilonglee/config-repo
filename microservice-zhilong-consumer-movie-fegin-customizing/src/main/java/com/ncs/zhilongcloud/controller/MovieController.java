package com.ncs.zhilongcloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.zhilongcloud.EurekaFeginClient;
import com.ncs.zhilongcloud.UserFeginClient;
import com.ncs.zhilongcloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeginClient userFeginClient;
	
	@Autowired
	private EurekaFeginClient eurekaFeginClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return userFeginClient.findById(id);
	}
	
	@GetMapping("/test")
	public User postUserTest(){
		User user = new User();
		user.setAge(18);
		user.setBalance(BigDecimal.valueOf(200d));
		user.setId(6l);
		user.setName("caichao");
		user.setUsername("caichaowangba");
		return userFeginClient.postUserTest(user);
	}
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoViaEurekaApps(@PathVariable String serviceName){
		return eurekaFeginClient.findServiceInfoViaEurekaApps(serviceName);
	}
}
