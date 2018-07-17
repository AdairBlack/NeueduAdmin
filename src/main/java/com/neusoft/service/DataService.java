package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.vo.ChartDataVo;

public interface DataService {
	public ChartDataVo findChartDataVo(int qid) throws Exception;
}
