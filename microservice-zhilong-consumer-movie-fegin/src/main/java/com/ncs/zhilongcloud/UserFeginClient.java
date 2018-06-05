package com.ncs.zhilongcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncs.zhilongcloud.entity.User;

@FeignClient("microservice-zhilong-provider-user-v1")
public interface UserFeginClient {
	@RequestMapping(method = RequestMethod.GET, value = "/simple/{id}")
	public User findById(@PathVariable("id") Long id);

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public User postUserTest(@RequestBody User user);
}
