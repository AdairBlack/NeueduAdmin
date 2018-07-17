package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.FreeListenBook;

public interface FreeListenBookService {
	public List<FreeListenBook> findAll(int qid) throws SQLException;
	public List<FreeListenBook> findAllByPage(int qid, int page, int limit) throws SQLException;
	public List<FreeListenBook> findSome(Map map) throws SQLException;
	public List<FreeListenBook> findSomeByPage(Map map) throws SQLException;
	public int countFindSome(Map map) throws SQLException;
	public int manipulateBook(int id) throws SQLException;

}
