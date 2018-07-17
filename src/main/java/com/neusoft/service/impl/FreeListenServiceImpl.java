package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.FreeListen;
import com.neusoft.mapper.FreeListenMapper;
import com.neusoft.service.FreeListenService;


@Service
public class FreeListenServiceImpl implements FreeListenService {

	@Autowired
	private FreeListenMapper freeListenMapper;

	@Override
	public boolean addFreeListen(FreeListen freeListen) throws SQLException {
		System.out.println("......FreeListenService......addFreeListen()......");
		freeListenMapper.addFreeListen(freeListen);
		return true;
	}

	@Override
	public FreeListen findFreeListenById(int id) throws SQLException {
		System.out.println("......FreeListenService......findFreeListenById()......");
		FreeListen freeListen = freeListenMapper.findFreeListenById(id);
		return freeListen;
	}

	@Override
	public List<FreeListen> findAll(int qid) throws SQLException {
		System.out.println("......FreeListenService......findAll()......");
		List<FreeListen> freeListens = freeListenMapper.findAll(qid);
		return freeListens;
	}

	@Override
	public List<FreeListen> findSome(Map map) throws SQLException {
		
		return freeListenMapper.findSome(map);
	}

	@Override
	public boolean deleteFreeListen(int id) throws Exception {
		freeListenMapper.deleteFreeListen(id);
		return true;
	}

	@Override
	public boolean updateFreeListen(FreeListen freeListen) throws Exception {
		freeListenMapper.updateFreeListen(freeListen);
		return true;
	}

}
