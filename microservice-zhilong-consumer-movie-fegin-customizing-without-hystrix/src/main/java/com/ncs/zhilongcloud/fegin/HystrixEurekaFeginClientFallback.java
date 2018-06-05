package com.ncs.zhilongcloud.fegin;

import org.springframework.stereotype.Component;


@Component
public class HystrixEurekaFeginClientFallback implements EurekaFeginClient{

	@Override
	public String findServiceInfoViaEurekaApps(String serviceName) {
		return "hahaha";
	}

}
