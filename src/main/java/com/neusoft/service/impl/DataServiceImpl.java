package com.neusoft.service.impl;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Lesson;
import com.neusoft.bean.LessonBranch;
import com.neusoft.bean.Order;
import com.neusoft.mapper.EnterpriseMapper;
import com.neusoft.mapper.LessonBranchMapper;
import com.neusoft.mapper.LessonMapper;
import com.neusoft.mapper.OrderMapper;
import com.neusoft.mapper.SwiperMapper;
import com.neusoft.service.DataService;
import com.neusoft.vo.ChartDataVo;
import com.neusoft.vo.LessonCategoryVo;
import com.neusoft.vo.LessonDataVo;
import com.neusoft.vo.YearData;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private EnterpriseMapper enterpriseMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private LessonMapper lessonMapper;
	
	/**
	 * 查找近10年的数据
	 * 先找到最近的订单的年份
	 * 再往前10年
	 */
	@Override
	public ChartDataVo findChartDataVo(int qid) throws Exception {
		System.out.println("......DataService......findChartDataVo......");
		
		//近10年的数据
		ChartDataVo chartDataVo = new ChartDataVo();
		
		List<LessonCategoryVo> lessonCategoryVos = new ArrayList();
		
		List<String> categorys = lessonMapper.findAllCategory(qid);
		
		List<String> branchs = enterpriseMapper.findAllBranchName(qid);
		chartDataVo.setBranchs(branchs);
		
		List<Integer> branchIds = enterpriseMapper.findAllBranchId(qid);
		chartDataVo.setBranchIds(branchIds);
		
		Order order = orderMapper.findMostRecentYear(qid);
		
		Timestamp ts = order.getOrderTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(ts.getTime()));
		int year = cal.get(Calendar.YEAR);
		chartDataVo.setStartYear(year-9);
		chartDataVo.setEndYear(year);
		System.out.println("......Most Recent Order's year: " + year + "......");
		
		for(int i = 0; i < categorys.size(); i++) {
			LessonCategoryVo lessonCategoryVo = new LessonCategoryVo();
			lessonCategoryVo.setCategory(categorys.get(i));
			List<YearData> yearDatas = new ArrayList<>();
			
			for(int j = year - 9; j <= year; j++) {
				YearData yearData = new YearData();
				yearData.setYear(j);
				List<Double> branchDatas = new ArrayList<>();
				for(int k = 0; k < branchs.size(); k++) {
					Map map = new HashMap();
					map.put("qid", qid);
					map.put("category", categorys.get(i));
					map.put("branchid", branchIds.get(k));
					map.put("year", j);
					Double branchData = orderMapper.findOrderActualSumByLessonBranchYear(map);
					if(branchData == null) {
						branchData = (double) 0;
					}
					branchDatas.add(branchData);
					
				}
				yearData.setBranchDatas(branchDatas);
				yearDatas.add(yearData);
				
			}
			lessonCategoryVo.setYearDatas(yearDatas);
			lessonCategoryVos.add(lessonCategoryVo);
			
		}
		chartDataVo.setLessonCategoryVos(lessonCategoryVos);
		
		
		return chartDataVo;
	}

}
