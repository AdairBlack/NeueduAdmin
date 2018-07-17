package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.User;
import com.neusoft.mapper.UserMapper;
import com.neusoft.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean updateUser(User user) throws SQLException {
		System.out.println("......UserService......updateUser()......");
		userMapper.updateUserPassword(user);
		return true;
	}
	@Override
	public User findUserByUsernameAndUserpassword(User user) throws Exception {
		System.out.println("......UserService......findUserByUsernameAndUserpassword()......");
		userMapper.findUserByUsernameAndUserpassword(user);
		return userMapper.findUserByUsernameAndUserpassword(user);
	}
	@Override
	public List<User> findAllAdmin() throws Exception {
		System.out.println("......UserService......findAllAdmin()......");
		return userMapper.findAllAdmin();
	}
	@Override
	public boolean saveAdmin(User user) throws Exception {
		userMapper.saveEmptyEnterprise(user);
		userMapper.saveAdmin(user);
		
		return true;
	}
	@Override
	public boolean deleteAdmin(int id) throws Exception {
		userMapper.deleteAdmin(id);
		return true;
	}
	

}
