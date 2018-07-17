package com.neusoft.mapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.FreeListenBook;
import com.neusoft.vo.IdQidVO;

public interface FreeListenBookMapper {
	public List<FreeListenBook> findAll(int qid) throws SQLException;
	public FreeListenBook findById(IdQidVO idQidVO) throws SQLException;
	public List<FreeListenBook> findSome(Map map) throws SQLException;
	public int countFindSome(Map map) throws SQLException;
	public List<FreeListenBook> findSomeByPage(Map map) throws SQLException;
	public int manipulateBook(int id) throws SQLException;
	public List<FreeListenBook> findAllByPage(Map map) throws SQLException;
}
