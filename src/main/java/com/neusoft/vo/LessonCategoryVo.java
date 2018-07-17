package com.neusoft.vo;

import java.util.List;

public class LessonCategoryVo {
	
	private String category;
	private List<YearData> yearDatas;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<YearData> getYearDatas() {
		return yearDatas;
	}
	public void setYearDatas(List<YearData> yearDatas) {
		this.yearDatas = yearDatas;
	}
	
	
}
