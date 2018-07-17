package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Swiper;
import com.neusoft.bean.Teacher;

public interface TeacherService {
	public List<Teacher> findAllTeacher(int qid) throws Exception;
	public boolean deleteTeacher(int tid) throws Exception;
	public Teacher findTeacherById(int tid) throws Exception;
	public boolean updateTeacher(Teacher teacher) throws Exception;
	public boolean saveTeacher(Teacher teacher) throws Exception;
	public List<String> findImages(int qid) throws Exception;
	public boolean saveImages(int qid, List<Swiper> swipers) throws Exception;
}
