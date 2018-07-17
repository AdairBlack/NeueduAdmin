package com.neusoft.mapper;

import java.util.List;

import com.neusoft.bean.LessonBranch;

public interface LessonBranchMapper {
	public int saveLessonBranch(LessonBranch lessonBranch) throws Exception;
	public int deleteLessonBranchByLessonId(int lid) throws Exception;
	public List<LessonBranch> findLessonBranchByBranchId(int id) throws Exception;
	public List<LessonBranch> findLessonBranchByLessonId(int id) throws Exception;
	public List<LessonBranch> findAll(int qid) throws Exception;
}
