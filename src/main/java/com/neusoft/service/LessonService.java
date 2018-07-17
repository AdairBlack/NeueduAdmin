package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Lesson;
import com.neusoft.bean.LessonBranch;

public interface LessonService {
	public List<Lesson> findAll(int qid) throws SQLException;
	public List<LessonBranch> findAllLessonBranch(int qid) throws Exception;
	public Lesson findLessonById(int lid) throws Exception;
	public boolean saveLesson(Lesson lesson, Integer[] branches) throws Exception;
	public boolean updateLesson(Lesson lesson, Integer[] branches) throws Exception;
	public boolean deleteLesson(int lid) throws Exception;
}
