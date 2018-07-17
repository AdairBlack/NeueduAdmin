package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Order;
import com.neusoft.mapper.OrderMapper;
import com.neusoft.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<Order> findSome(Map map) throws SQLException {
		// TODO Auto-generated method stub
		return orderMapper.findSome(map);
	}
	@Override
	public List<Order> findAll(int qid) throws SQLException {
		// TODO Auto-generated method stub
		return orderMapper.findAll(qid);
	}
	@Override
	public int countFindSome(Map map) throws SQLException {
		// TODO Auto-generated method stub
		return orderMapper.countFindSome(map);
	}
	@Override
	public void manipulate(int oid) throws SQLException {
		orderMapper.manipulate(oid);
		
	}

}
