package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Teacher;

public interface TeacherMapper {
	public List<Teacher> findAllTeacher(int qid) throws Exception;
	public int deleteTeacher(int tid) throws Exception;
	public Teacher findTeacherById(int tid) throws Exception;
	public int updateTeacher(Teacher teacher) throws Exception;
	public int saveTeacher(Teacher teacher) throws Exception;
}
