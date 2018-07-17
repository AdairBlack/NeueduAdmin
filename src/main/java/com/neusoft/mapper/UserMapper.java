package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.User;

public interface UserMapper {
	public User findUserByUsernameAndUserpassword(User user) throws SQLException;
	public int updateUserPassword(User user) throws SQLException;
	public List<User> findAllAdmin() throws Exception;
	public int saveEmptyEnterprise(User user) throws Exception;
	public int saveAdmin(User user) throws Exception;
	public int deleteAdmin(int id) throws Exception;
}
