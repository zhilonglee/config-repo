package com.ncs.zhilong.component;

import java.util.List;

import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Component;

import com.ncs.zhilong.TestFactoty;

@Component
public class MyTest {

	public String test() {
		return "test------------";
	}
	
	public String name() {
		List<String> loadFactoryNames = SpringFactoriesLoader.loadFactoryNames(TestFactoty.class, null);
		return loadFactoryNames.toString();
	}
	
	public String loadclass() {
		List<TestFactoty> loadFactories = SpringFactoriesLoader.loadFactories(TestFactoty.class, null);
		return loadFactories.get(0).name() +loadFactories.get(1).name();
	}
}
