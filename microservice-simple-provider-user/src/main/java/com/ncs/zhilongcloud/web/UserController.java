package com.ncs.zhilongcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.zhilongcloud.entity.User;
import com.ncs.zhilongcloud.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id){
		return userService.findById(id);
	}

}
