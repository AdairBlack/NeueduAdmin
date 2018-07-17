package com.neusoft.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.Swiper;
import com.neusoft.bean.Teacher;
import com.neusoft.service.TeacherService;
import com.neusoft.tools.FileUpload;

@Controller
public class TeacherHandler {
	private static final String imagePath = "/upload/image/";
	
	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "/teacher/TeacherHandler_findAllTeacher")
	@ResponseBody
	public List<Teacher> findAllTeacher(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......findAllTeacher()..........");
		List<Teacher> list = teacherService.findAllTeacher(qid);
		for(Teacher t : list) {
			t.setTphoto(imagePath + t.getTphoto());
		}
		return list;
	}
	
	@RequestMapping(value = "/teacher/TeacherHandler_findTeacherById")
	@ResponseBody
	public Teacher findTeacherById(int tid, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......findTeacherById()..........");
		Teacher teacher = teacherService.findTeacherById(tid);
		
		teacher.setTphoto(imagePath + teacher.getTphoto());
		
		return teacher;
	}
	
	@RequestMapping(value = "/teacher/TeacherHandler_deleteTeacher")
	@ResponseBody
	public String deleteTeacher(int tid, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......deleteTeacher()..........");
		
		Teacher teacher = teacherService.findTeacherById(tid);
		FileUpload fileUpload = new FileUpload(request);
		List<String> deleteList = new ArrayList<>();
		deleteList.add(teacher.getTphoto());
		fileUpload.imageDelete(deleteList);
		
		teacherService.deleteTeacher(tid);
		
		return "{\"result\":\"删除成功\"}";
	}
	
	@RequestMapping(value = "/teacher/TeacherHandler_updateTeacher")
	@ResponseBody
	public String updateTeacher(int qid,int tid, String tname, String introduction, boolean imageChanged, String tphoto, @RequestParam MultipartFile[] teacherImage, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......updateTeacher()..........");
		String imageFilename;
		
		FileUpload fileUpload = new FileUpload(request);
		
		if(imageChanged) {
			imageFilename = fileUpload.imageUpload(teacherImage).get(0);
		} else {
			imageFilename = tphoto.split("/")[3];
		}
		
		Teacher teacher = new Teacher();
		teacher.setQid(qid);
		teacher.setTid(tid);
		teacher.setTname(tname);
		teacher.setTphoto(imageFilename);
		teacher.setIntroduction(introduction);

		teacherService.updateTeacher(teacher);
		
		
		return "{\"result\":\"编辑成功\"}";
	}
	
	@RequestMapping(value = "/teacher/TeacherHandler_saveTeacher")
	@ResponseBody
	public String saveTeacher(int qid,String tname, String introduction, @RequestParam MultipartFile[] teacherImage, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......saveTeacher()..........");
		String imageFilename;
		
		FileUpload fileUpload = new FileUpload(request);
		
		imageFilename = fileUpload.imageUpload(teacherImage).get(0);
		
		Teacher teacher = new Teacher();
		teacher.setQid(qid);
		teacher.setTname(tname);
		teacher.setTphoto(imageFilename);
		teacher.setIntroduction(introduction);

		teacherService.saveTeacher(teacher);
		
		
		return "{\"result\":\"保存成功\"}";
	}
	
	@RequestMapping(value = "/teacher/TeacherHandler_findImages")
	@ResponseBody
	public List<String> findImages(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......findImages()..........");
		List<String> list = teacherService.findImages(qid);
		for(int i = 0; i < list.size(); i++) {
			list.set(i, imagePath + list.get(i));
		}
		return list;
	}
	
	@RequestMapping(value = "/teacher/TeacherHandler_saveImages")
	@ResponseBody
	public String saveImages(int qid, boolean imageChanged, String[] imageFilenames,@RequestParam MultipartFile[] images, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......saveImages()..........");
		List<String> filenames;
		List<Swiper> swipers = new ArrayList();
		FileUpload fileUpload = new FileUpload(request);
		System.out.println(imageChanged);
		
		if(imageChanged) {
			filenames = fileUpload.imageUpload(images);
			for(String s : filenames) {
				Swiper swiper = new Swiper();
				swiper.setImgurl(s);
				swiper.setQid(qid);
				swipers.add(swiper);
			}
		} else {
			for(int i = 0; i < imageFilenames.length; i++) {
				imageFilenames[i] = imageFilenames[i].split("/")[3];
				Swiper swiper = new Swiper();
				swiper.setQid(qid);
				swiper.setImgurl(imageFilenames[i]);
				swipers.add(swiper);
			}
		}
		
		teacherService.saveImages(qid, swipers);
		
		
		return "{\"result\":\"保存成功\"}";
	}
	
}
