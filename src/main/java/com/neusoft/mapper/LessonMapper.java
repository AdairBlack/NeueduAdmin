package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Lesson;
import com.neusoft.vo.IdQidVO;

public interface LessonMapper {
	public List<Lesson> findAll(int qid) throws SQLException;
	public Lesson findLessonById(int lid) throws SQLException;
	public int saveLesson(Lesson lesson) throws SQLException;
	public int updateLesson(Lesson lesson) throws SQLException;
	public int deleteLesson(int lid) throws Exception;
	public List<String> findAllCategory(int qid) throws Exception;
}
