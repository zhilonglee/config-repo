 package com.ncs.zhilongcloud.fegin;

import org.springframework.stereotype.Component;

import com.ncs.zhilongcloud.entity.User;



@Component
public class HystrixClientFallback implements UserFeginClient {

  @Override
  public User findById(Long id) {
    User user = new User();
    user.setId(0L);
    return user;
  }
}