package com.ncs.zhilongcloud.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncs.config.FeginConfigruation2;

@FeignClient(name="xxxxxxx",url="http://localhost:8761/",configuration = FeginConfigruation2.class,fallback = HystrixEurekaFeginClientFallback.class)
public interface EurekaFeginClient {

	@RequestMapping(method=RequestMethod.GET,value="/eureka/apps/{serviceName}")
	String findServiceInfoViaEurekaApps(@PathVariable("serviceName") String serviceName);
}
