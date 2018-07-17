package com.neusoft.mapper;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Order;

public interface OrderMapper {
	public List<Order> findAll(int qid) throws SQLException;
	public List<Order> findSome(Map map) throws SQLException;
	public int countFindSome(Map map) throws SQLException;
	public void manipulate(int oid) throws SQLException;
	public Order findMostRecentYear(int qid) throws SQLException;
	public Double findOrderActualSumByLessonBranchYear(Map map) throws SQLException;
	
}
