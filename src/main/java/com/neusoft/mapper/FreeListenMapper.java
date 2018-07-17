package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.FreeListen;
import com.neusoft.vo.FreeListenBookTableVO;

import javafx.scene.chart.PieChart.Data;

public interface FreeListenMapper {
	public int addFreeListen(FreeListen freeListen) throws SQLException;
	public FreeListen findFreeListenById(int id) throws SQLException;
	public List<FreeListen> findAll(int qid) throws SQLException;
	public int deleteFreeListen(int id) throws Exception;
	public int updateFreeListen(FreeListen freeListen) throws Exception;
	
	public List<FreeListen> findSome(Map map) throws SQLException;

}
