package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.User;

public interface LoginService {
	public User findUserByUsernameAndUserpassword(User user) throws Exception;
}
