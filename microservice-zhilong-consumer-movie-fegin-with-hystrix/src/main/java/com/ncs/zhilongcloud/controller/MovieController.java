package com.ncs.zhilongcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.zhilongcloud.entity.User;
import com.ncs.zhilongcloud.fegin.UserFeginClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeginClient userFeginClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return userFeginClient.findById(id);
	}
	

}
