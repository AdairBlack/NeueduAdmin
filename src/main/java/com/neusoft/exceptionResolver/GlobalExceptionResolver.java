package com.neusoft.exceptionResolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver{
	
	//定义一个日志对象
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception ex) {
		//1.记录错误日志
		logger.info("系统异常info");
		logger.error("系统异常", ex);
		
		if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request  
                .getHeader("X-Requested-With")!= null && request  
                .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {  
            // 如果不是异步请求  
        	ModelAndView mav = new ModelAndView();
    		mav.setViewName("/publicPages/globalerror.html");
    		return mav; 
        } else {  
            try {  
            	//字符串
                PrintWriter writer = response.getWriter();  
                writer.write(ex.getMessage());  
                writer.flush();  
            } catch (IOException e) {  
                e.printStackTrace();
            }  
            return null;   
        }
		/**
		 * if(ajax)
		 * {
		 * 		response响应.
		 * }
		 * else
		 * {
		 * 		跳转到全局异常页
		 * }
		 */
		//ModelAndView mav = new ModelAndView();
		/**
		 * 请求转发: / 工程路径之后 http://ip:port/projectname/
		 * 请求重定向： / http://ip:port/ 告诉客户端重发请求
		 * 
		 * 前台代码:(html, jsp)
		 *     /  http://ip:port/
		 */
		//mav.setViewName("/pages/globalerror.html");
		//return mav;
	}
	
}
