package com.neusoft.control;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neusoft.bean.FreeListenBook;
import com.neusoft.bean.Order;
import com.neusoft.service.OrderService;
import com.neusoft.vo.FreeListenBookTableVO;
import com.neusoft.vo.OrderTableVO;

@Controller
public class OrderHandler {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/OrderHandler_findSome")
	@ResponseBody
	public List<Order> findSome(int qid,String name,Integer oid,HttpServletRequest request,Integer limit,Integer beginPage) throws Exception{
		System.out.println("............FreeListenOrderHandler_findSome..............");
		Map map = new HashMap<>();
		map.put("qid", qid);
		map.put("username", name);
		if(!("NaN".equals(request.getParameter("fromDate"))))
			map.put("fromDate", new Timestamp(Long.valueOf(request.getParameter("fromDate"))));
		else
			map.put("fromDate", null);
		if(!("NaN".equals(request.getParameter("toDate"))))
			map.put("toDate", new Timestamp(Long.valueOf(request.getParameter("toDate"))));
		else
			map.put("toDate", null);
		map.put("oid", oid);
		map.put("limit", limit);
		map.put("beginPage", beginPage);
		List<Order> orders = orderService.findSome(map);
		return orders;
	}
	
	@RequestMapping(value="/order/OrderHandler_findSomeByPage")
	@ResponseBody
	public String findOrderByPage(int qid,String name,Integer oid,HttpServletRequest request,Integer limit,Integer page) throws Exception{
		System.out.println("............FreeListenOrderHandler_findSomeByPages..............");
		System.out.println(limit);
		System.out.println(page);
		Map map = new HashMap<>();
		map.put("qid", qid);
		map.put("username", name);
		if(!("NaN".equals(request.getParameter("fromDate")))&&!(null==request.getParameter("fromDate")))
			map.put("fromDate", new Timestamp(Long.valueOf(request.getParameter("fromDate"))));
		else
			map.put("fromDate", null);
		if(!("NaN".equals(request.getParameter("toDate")))&&!(null==request.getParameter("toDate")))
			map.put("toDate", new Timestamp(Long.valueOf(request.getParameter("toDate"))));
		else
			map.put("toDate", null);
		if(!("NaN".equals(request.getParameter("status")))&&!(null==request.getParameter("status")))
			map.put("status", request.getParameter("status"));
		else
			map.put("status", null);
		map.put("oid", oid);
		map.put("limit", limit);
		map.put("beginPage", (page - 1) * limit);
		List<Order> orders = orderService.findSome(map);
		List<OrderTableVO> orderTableVOs = new ArrayList<>();
		for(Order order:orders) {
			OrderTableVO orderTableVO= new OrderTableVO(order);
			orderTableVOs.add(orderTableVO);			
		}
		if(orderTableVOs.size()>0) {
			Gson gson = new Gson();
			String toReturn ="{\"code\":0,\"msg\":\"\",\"count\":"+orderService.countFindSome(map)+",\"data\":";
			String ordersJson = gson.toJson(orderTableVOs);
			System.out.println(toReturn+ordersJson+"}");
			return toReturn+ordersJson+"}";
		}
		else
			return null;
	}
	@RequestMapping(value="/order/OrderHandler_manipulate")
	@ResponseBody
	public String manipulate(int qid,String name,Integer oid,HttpServletRequest request) throws Exception{
		orderService.manipulate(oid);
		return "{\"result\":\"编辑成功\"}";
	}
	
	
	
	



}
