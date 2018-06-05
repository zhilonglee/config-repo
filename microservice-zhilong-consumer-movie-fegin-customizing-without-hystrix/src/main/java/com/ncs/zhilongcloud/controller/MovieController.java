package com.ncs.zhilongcloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.zhilongcloud.entity.User;
import com.ncs.zhilongcloud.fegin.EurekaFeginClient;
import com.ncs.zhilongcloud.fegin.UserFeginClient;

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
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoViaEurekaApps(@PathVariable String serviceName){
		return eurekaFeginClient.findServiceInfoViaEurekaApps(serviceName);
	}
}
