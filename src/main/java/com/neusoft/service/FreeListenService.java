package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.FreeListen;

public interface FreeListenService {
	public FreeListen findFreeListenById(int id) throws SQLException;
	public List<FreeListen> findAll(int qid) throws SQLException;
	public boolean addFreeListen(FreeListen freeListen) throws SQLException;
	public boolean deleteFreeListen(int id) throws Exception;
	public boolean updateFreeListen(FreeListen freeListen) throws Exception;
	
	public List<FreeListen> findSome(Map map) throws SQLException;
}
