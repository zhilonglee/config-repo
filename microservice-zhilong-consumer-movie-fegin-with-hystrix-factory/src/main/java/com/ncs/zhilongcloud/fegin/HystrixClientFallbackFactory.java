package com.ncs.zhilongcloud.fegin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ncs.zhilongcloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements
		FallbackFactory<UserFeginClient> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HystrixClientFallbackFactory.class);

	@Override
	public UserFeginClient create(Throwable cause) {
		LOGGER.info("fallback; reason was: " + cause.getMessage());
		return new UserFeignClientwithFactory() {

			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1l);
				return user;
			}
		};
	}

}
