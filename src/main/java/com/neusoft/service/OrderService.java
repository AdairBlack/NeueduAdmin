package com.neusoft.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Order;

public interface OrderService {
	public List<Order> findAll(int qid) throws SQLException;
	public List<Order> findSome(Map map) throws SQLException;
	public int countFindSome(Map map) throws SQLException;
	public void manipulate(int oid) throws SQLException;
}
