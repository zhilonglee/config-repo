package com.ncs.zhilong.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.zhilong.component.MyTest;
import com.ncs.zhilong.component.UserClient;
import com.ncs.zhilong.config.ServiceAppConfig;
import com.ncs.zhilong.entity.User;

@RestController
@RefreshScope
public class CustomingPropertiesWeb {


	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ServiceAppConfig serviceAppConfig;
	
	@Autowired
	UserClient userClient;
	
	@GetMapping("/simple")
	public String simple(){
		MyTest mytest = applicationContext.getBean(MyTest.class);
		return mytest.test()
				+"\n"
				+mytest.name()
				+"\n"
				+mytest.loadclass();
	}
	
	@GetMapping("/refreshscope")
	public String refreshScope(){
		return serviceAppConfig.getApiUrl();
	}
	
	@GetMapping("/movie/{id}")
	public User movie(@PathVariable Long id){
		return userClient.findById(id);
	}
	
}
