package com.ncs.zhilongcloud.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.ncs.config.FeginConfigruation;
import com.ncs.zhilongcloud.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="microservice-zhilong-provider-user",configuration={FeginConfigruation.class},fallback = HystrixClientFallback.class)
public interface UserFeginClient {
	//@RequestMapping(method = RequestMethod.GET, value="/simple/{id}")
	//public User findById(@PathVariable("id") Long id);
	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
}
