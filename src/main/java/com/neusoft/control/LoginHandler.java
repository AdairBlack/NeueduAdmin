package com.neusoft.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;
import com.neusoft.bean.User;
import com.neusoft.service.LoginService;


@Controller
public class LoginHandler {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login/LoginHandler_login")
	public String login(String username, String userpassword, HttpServletRequest request) throws Exception {
		System.out.println("......LoginHandler......login()..........");
		HttpSession session = request.getSession();
		boolean exists = false;
		User user = new User();
		user.setUsername(username);
		user.setUserpassword(userpassword);
		user = loginService.findUserByUsernameAndUserpassword(user);
		if(user == null) {
			return "redirect:/publicPages/noPermission.html";
		}
		if("管理员".equals(user.getJurisdiction())) {
			session.setAttribute("user", user);
			return "redirect:/pages/parent.html?qid=" + user.getQid();
		} else if("超级管理员".equals(user.getJurisdiction())) {
			session.setAttribute("user", user);
			return "redirect:/pages/super.html";
			
		}
		return "redirect:/publicPages/noPermission.html";
	}
	@RequestMapping(value = "/login/LoginHandler_logout")
	public String logout(HttpServletRequest request) throws Exception {
		System.out.println("......LoginHandler......logout()..........");
		HttpSession session = request.getSession();
		System.out.println("......Why Not Compile? Eclipse, you are very naughty!......");
		session.removeAttribute("user");
		return "redirect:/index.html";
	}
}
