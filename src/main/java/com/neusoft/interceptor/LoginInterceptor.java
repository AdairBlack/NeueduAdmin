package com.neusoft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("......LoginInterceptor......afterCompletion().......");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("......LoginInterceptor......postHandle().......");
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("......LoginInterceptor......preHandle().......");
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null){
			
			return true;
		} else {
			System.out.println("......intercepted......");
			request.getRequestDispatcher("/publicPages/noLogin.html").forward(request, response);
			return false;
		}
	}

}
