package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Lesson;
import com.neusoft.bean.LessonBranch;
import com.neusoft.mapper.LessonBranchMapper;
import com.neusoft.mapper.LessonMapper;
import com.neusoft.service.LessonService;
@Service
public class LessonServiceImpl implements LessonService {

	@Autowired
	private LessonMapper lessonMapper;
	@Autowired
	private LessonBranchMapper lessonBranchMapper;
	
	@Override
	public List<Lesson> findAll(int qid) throws SQLException {
		System.out.println("......LessonService......findAll()......");
		return lessonMapper.findAll(qid);
	}
	
	@Override
	public List<LessonBranch> findAllLessonBranch(int qid) throws Exception {
		System.out.println("......LessonService......findAllLessonBranch()......");
		return lessonBranchMapper.findAll(qid);
	}
	
	@Override
	public Lesson findLessonById(int lid) throws Exception {
		System.out.println("......LessonService......findLessonById()......");
		Lesson lesson= lessonMapper.findLessonById(lid);
		List<LessonBranch> lessonBranches = lessonBranchMapper.findLessonBranchByLessonId(lid);
		List<EnterpriseBranch> branches = new ArrayList();
		for(int i = 0; i < lessonBranches.size(); i++) {
			EnterpriseBranch branch = new EnterpriseBranch();
			branch.setId(lessonBranches.get(i).getBranchId());
			branches.add(branch);
		}
		lesson.setBranchs(branches);
		return lesson;
	}
	
	@Override
	public boolean saveLesson(Lesson lesson, Integer[] branches) throws Exception {
		System.out.println("......LessonService......saveLesson()......");
		lessonMapper.saveLesson(lesson);
		for(int i = 0;i < branches.length; i++) {
			LessonBranch lessonBranch = new LessonBranch();
			lessonBranch.setBranchId(branches[i]);
			lessonBranch.setLid(lesson.getLid());
			lessonBranchMapper.saveLessonBranch(lessonBranch);
		}
		return true;
	}
	
	@Override
	public boolean updateLesson(Lesson lesson, Integer[] branches) throws Exception {
		System.out.println("......LessonService......saveLesson()......");
		lessonMapper.updateLesson(lesson);
		lessonBranchMapper.deleteLessonBranchByLessonId(lesson.getLid());
		for(int i = 0;i < branches.length; i++) {
			LessonBranch lessonBranch = new LessonBranch();
			lessonBranch.setBranchId(branches[i]);
			lessonBranch.setLid(lesson.getLid());
			lessonBranchMapper.saveLessonBranch(lessonBranch);
		}
		return true;
	}
	
	@Override
	public boolean deleteLesson(int lid) throws Exception {
		System.out.println("......LessonService......deleteLesson()......");
		lessonMapper.deleteLesson(lid);
		return true;
	}

}
