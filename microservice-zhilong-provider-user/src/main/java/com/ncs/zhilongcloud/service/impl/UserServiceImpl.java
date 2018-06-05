package com.ncs.zhilongcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.zhilongcloud.dao.UserRepository;
import com.ncs.zhilongcloud.entity.User;
import com.ncs.zhilongcloud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(Long id) {

		return userRepository.findOne(id);
	}

}
