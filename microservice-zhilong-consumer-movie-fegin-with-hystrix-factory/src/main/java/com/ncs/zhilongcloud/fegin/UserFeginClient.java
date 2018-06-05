package com.ncs.zhilongcloud.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncs.zhilongcloud.entity.User;

@FeignClient(name = "microservice-zhilong-provider-user", /*
														 * fallback =
														 * HystrixClientFallback
														 * .class,
														 */fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeginClient {
	@RequestMapping(method = RequestMethod.GET, value = "/simple/{id}")
	public User findById(@PathVariable("id") Long id);

}
