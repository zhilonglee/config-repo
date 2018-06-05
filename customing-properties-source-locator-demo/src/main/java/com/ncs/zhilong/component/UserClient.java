package com.ncs.zhilong.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.zhilong.entity.User;


@FeignClient("microservice-zhilong-provider-user")
public interface UserClient {

	@RequestMapping(value="/simple/{id}")
	public User findById(@PathVariable("id") Long id);
}
