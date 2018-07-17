package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Swiper;
import com.neusoft.bean.Teacher;
import com.neusoft.mapper.SwiperMapper;
import com.neusoft.mapper.TeacherMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private SwiperMapper swiperMapper;

	@Override
	public List<Teacher> findAllTeacher(int qid) throws Exception {
		return teacherMapper.findAllTeacher(qid);
	}

	@Override
	public boolean deleteTeacher(int tid) throws Exception {
		teacherMapper.deleteTeacher(tid);
		return true;
	}

	@Override
	public Teacher findTeacherById(int tid) throws Exception {
		return teacherMapper.findTeacherById(tid);
	}
	
	@Override
	public boolean updateTeacher(Teacher teacher) throws Exception {
		teacherMapper.updateTeacher(teacher);
		return true;
	}
	
	@Override
	public boolean saveTeacher(Teacher teacher) throws Exception {
		teacherMapper.saveTeacher(teacher);
		return true;
	}
	
	@Override
	public List<String> findImages(int qid) throws Exception {
		
		return swiperMapper.findTeacherImages(qid);
	}

	@Override
	public boolean saveImages(int qid,List<Swiper> swipers) throws Exception {
		swiperMapper.deleteTeacherImage(qid);
		for(Swiper s : swipers) {
			swiperMapper.saveTeacherImage(s);
		}
		return true;
	}
	
	

}
