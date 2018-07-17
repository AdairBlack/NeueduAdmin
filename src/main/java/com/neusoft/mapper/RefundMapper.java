package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Order;
import com.neusoft.bean.Refund;

public interface RefundMapper {
	public List<Refund> findAll(int qid) throws SQLException;
	public List<Refund> findSome(Map map) throws SQLException;
	public int countFindSome(Map map) throws SQLException;
	public void manipulate(int oid) throws SQLException;

}
