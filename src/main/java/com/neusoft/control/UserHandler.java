package com.neusoft.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.User;
import com.neusoft.service.DataService;
import com.neusoft.service.EnterpriseService;
import com.neusoft.service.UserService;
import com.neusoft.tools.FileUpload;
import com.neusoft.vo.ChartDataVo;

@Controller
public class UserHandler {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/UserHandler_updateUser")
	@ResponseBody
	public String updateUser(String username, String userpassword,String newUsername, String newUserpassword, HttpServletRequest request) throws Exception {
		System.out.println("......UserHandler......updateUser()......");
		User user = new User();
		user.setUsername(username);
		user.setUserpassword(userpassword);
		
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");
		
		System.out.println("......" + sessionUser.getUsername() + "......");
		System.out.println("......" + sessionUser.getUserpassword() + "......");
		System.out.println("......" + username + "......");
		System.out.println("......" + userpassword + "......");
		
		if(!(sessionUser.getUsername().equals(username) && sessionUser.getUserpassword().equals(userpassword))) {
			return "{\"result\":\"用户名或密码错误\"}";
		}
		
		
		User newUser = new User();
		newUser.setId(sessionUser.getId());
		newUser.setUsername(newUsername);
		newUser.setUserpassword(newUserpassword);
		userService.updateUser(newUser);
		
		user.setUsername(newUsername);
		user.setUserpassword(newUserpassword);
		
		session.setAttribute("user", user);
		return "{\"result\":\"编辑成功\"}";
	}
	
	@RequestMapping(value = "/user/UserHandler_findAllAdmin")
	@ResponseBody
	public List<User> findAllAdmin(HttpServletRequest request) throws Exception {
		System.out.println("......UserHandler......findAllAdmin()......");
		List<User> users = userService.findAllAdmin();
		for(int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if(user.getQname() == null) {
				user.setQname("（暂无企业信息）");
			}
		}
		return users;
	}
	
	@RequestMapping(value = "/user/UserHandler_saveAdmin")
	@ResponseBody
	public String saveAdmin(String username, String userpassword, HttpServletRequest request) throws Exception {
		System.out.println("......UserHandler......saveAdmin()......");
		User user = new User();
		user.setUsername(username);
		user.setUserpassword(userpassword);
		userService.saveAdmin(user);
		return "{\"result\":\"添加成功\"}";
	}
	
	@RequestMapping(value = "/user/UserHandler_deleteAdmin")
	@ResponseBody
	public String deleteAdmin(int id, HttpServletRequest request) throws Exception {
		System.out.println("......UserHandler......deleteAdmin()......");
		userService.deleteAdmin(id);
		return "{\"result\":\"删除成功\"}";
	}
	
	@RequestMapping(value = "/user/UserHandler_findUsername")
	@ResponseBody
	public String findUsername(HttpServletRequest request) throws Exception {
		System.out.println("......UserHandler......findUsername()......");
		String username = ((User)request.getSession().getAttribute("user")).getUsername();
		return "{\"username\":\"" + username + "\"}";
	}
}
