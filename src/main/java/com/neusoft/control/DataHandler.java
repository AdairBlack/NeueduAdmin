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
import com.neusoft.service.DataService;
import com.neusoft.service.EnterpriseService;
import com.neusoft.tools.FileUpload;
import com.neusoft.vo.ChartDataVo;

@Controller
public class DataHandler {

	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/data/DataHandler_findChartDataVo")
	@ResponseBody
	public ChartDataVo findChartDataVo(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......DataHandler......findChartDataVo......");
		
		return dataService.findChartDataVo(qid);
	}
}
