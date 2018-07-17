package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.User;

public interface UserService {
	public boolean updateUser(User user) throws SQLException;
	public User findUserByUsernameAndUserpassword(User user) throws Exception;
	public List<User> findAllAdmin() throws Exception;
	public boolean saveAdmin(User user) throws  Exception;
	public boolean deleteAdmin(int id) throws Exception;
}
