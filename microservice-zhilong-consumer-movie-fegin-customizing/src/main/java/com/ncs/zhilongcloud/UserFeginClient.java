package com.ncs.zhilongcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ncs.config.FeginConfigruation;
import com.ncs.zhilongcloud.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="microservice-zhilong-provider-user",configuration={FeginConfigruation.class})
public interface UserFeginClient {
	//@RequestMapping(method = RequestMethod.GET, value="/simple/{id}")
	//public User findById(@PathVariable("id") Long id);
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
/*	@RequestMapping(method = RequestMethod.POST, value="/user")
	public User postUserTest(@RequestBody User user);*/
	@RequestLine("POST /user")
	public User postUserTest(User user);
}
