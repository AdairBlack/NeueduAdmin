package com.neusoft.vo;

import java.util.List;

public class ChartDataVo {
	
	private int startYear;
	private int endYear;
	
	private List<Integer> branchIds;
	
	private List<String> branchs;
	
	private List<LessonCategoryVo> lessonCategoryVos;

	
	public List<Integer> getBranchIds() {
		return branchIds;
	}

	public void setBranchIds(List<Integer> branchIds) {
		this.branchIds = branchIds;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public List<LessonCategoryVo> getLessonCategoryVos() {
		return lessonCategoryVos;
	}

	public void setLessonCategoryVos(List<LessonCategoryVo> lessonCategoryVos) {
		this.lessonCategoryVos = lessonCategoryVos;
	}

	public List<String> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<String> branchs) {
		this.branchs = branchs;
	}
	
	
	
}
