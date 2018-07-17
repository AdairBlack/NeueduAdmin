package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Refund;
import com.neusoft.mapper.RefundMapper;
import com.neusoft.service.RefundService;

@Service
public class RefundServiceImpl implements RefundService{

	@Autowired
	private RefundMapper refundMapper;
	@Override
	public List<Refund> findAll(int qid) throws SQLException {
		// TODO Auto-generated method stub
		return refundMapper.findAll(qid);
	}

	@Override
	public List<Refund> findSome(Map map) throws SQLException {
		// TODO Auto-generated method stub
		return refundMapper.findSome(map);
	}

	@Override
	public int countFindSome(Map map) throws SQLException {
		// TODO Auto-generated method stub
		return refundMapper.countFindSome(map);
	}

	@Override
	public void manipulate(int oid) throws SQLException {
		// TODO Auto-generated method stub
		refundMapper.manipulate(oid);
	}

}
