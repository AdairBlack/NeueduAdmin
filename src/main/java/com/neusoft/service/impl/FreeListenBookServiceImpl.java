package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.FreeListen;
import com.neusoft.bean.FreeListenBook;
import com.neusoft.mapper.FreeListenBookMapper;
import com.neusoft.service.FreeListenBookService;
import com.neusoft.service.FreeListenService;

@Service
public class FreeListenBookServiceImpl implements FreeListenBookService {

	
	@Autowired
	private FreeListenBookMapper freeListenBookMapper;

	@Override
	public List<FreeListenBook> findAll(int qid) throws SQLException {
		// TODO Auto-generated method stub
		return freeListenBookMapper.findAll(qid);
	}

	@Override
	public List<FreeListenBook> findSome(Map map) throws SQLException {
		// TODO Auto-generated method stub
		return freeListenBookMapper.findSome(map);
	}

	@Override
	public List<FreeListenBook> findAllByPage(int qid, int page, int limit) throws SQLException {
		System.out.println("......FreeListenBookServiceImpl......findOrderByPage()......");
		Map map = new HashMap();
		map.put("qid", qid);
		int beginPage = (page - 1) * limit;
		map.put("beginPage", beginPage);
		map.put("limit", limit);
		return freeListenBookMapper.findAllByPage(map);
	}

	@Override
	public List<FreeListenBook> findSomeByPage(Map map) throws SQLException {
		System.out.println("......FreeListenBookServiceImpl......findSomeByPage()......");
		return freeListenBookMapper.findSomeByPage(map);
	}

	@Override
	public int countFindSome(Map map) throws SQLException {
		// TODO Auto-generated method stub
		return freeListenBookMapper.countFindSome(map);
	}

	@Override
	public int manipulateBook(int id) throws SQLException {
		freeListenBookMapper.manipulateBook(id);
		return 0;
	}
	
}
