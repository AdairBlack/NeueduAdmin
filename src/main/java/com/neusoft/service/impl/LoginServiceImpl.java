package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.User;
import com.neusoft.mapper.UserMapper;
import com.neusoft.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User findUserByUsernameAndUserpassword(User user) throws Exception{
		return userMapper.findUserByUsernameAndUserpassword(user);
	}

}
