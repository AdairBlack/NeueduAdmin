package com.neusoft.control;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Lesson;
import com.neusoft.bean.LessonBranch;
import com.neusoft.service.LessonService;
import com.neusoft.tools.FileUpload;
import com.neusoft.tools.FilenameProcess;

@Controller
public class LessonHandler {
	private static final String imagePath = "/upload/image/";
	
	@Autowired
	private LessonService lessonService;
	
	
	@RequestMapping(value="/lesson/LessonHandler_findAll")
	@ResponseBody
	public List<Lesson> findAll(int qid)throws SQLException{
		System.out.println("......LessonHandler......findAll()......");
		List<Lesson> lessons = lessonService.findAll(qid);
		for(int i = 0; i < lessons.size(); i++) {
			lessons.get(i).setImgurl(imagePath + lessons.get(i).getImgurl());
		}
		return lessons;
	}
	
	@RequestMapping(value="/lesson/LessonHandler_findAllLessonBranch")
	@ResponseBody
	public List<LessonBranch> findAllLessonBranch(int qid)throws Exception{
		System.out.println("......LessonHandler......findAllLessonBranch()......");
		List<LessonBranch> lessonBranches = lessonService.findAllLessonBranch(qid);
		return lessonBranches;
	}
	
	
	@RequestMapping(value="/lesson/LessonHandler_findLessonById")
	@ResponseBody
	public Lesson findLessonById(int lid)throws Exception{
		Lesson lesson = lessonService.findLessonById(lid);
		lesson.setImgurl(imagePath + lesson.getImgurl());
		return lesson;
	}
	
	@RequestMapping(value="/lesson/LessonHandler_saveEditorImage")
	@ResponseBody
	public String saveEditorImage(@RequestParam MultipartFile upload, HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("......LessonHandler......saveEditorImage()..........");
		
		String path = request.getServletContext().getRealPath("/");
		File f = new File(path);
		String serverPath = f.getParent();
		
		String filename = System.currentTimeMillis() + upload.getOriginalFilename();
		
		
		//文件名中文及空格处理
		System.out.println("......Original Filename......");
		System.out.println(filename);
				
		FilenameProcess filenameProcess = new FilenameProcess();
		filename = filenameProcess.process(filename);
				
				
		System.out.println("......Processed Filename......");
		System.out.println(filename);
		
		File dest = new File(serverPath + imagePath, filename);
		upload.transferTo(dest);
		
		//Message to CKEditor
		String success = "{\"uploaded\": 1," +
			       "\"fileName\": \"" + filename + "\"," +
			       "\"url\": \"/upload/image/" + filename + "\"}";
		
		return success;
	}
	
	@RequestMapping(value = "/lesson/LessonHandler_saveLesson")
	@ResponseBody
	public String saveLesson(int qid, String lname, double lprice, String category, String ldesc, Integer[] branchId, @RequestParam MultipartFile[] image,
			  HttpServletRequest request) throws Exception {
		System.out.println("......LessonHandler......saveLesson()..........");
		String imageFilename;
		FileUpload fileUpload = new FileUpload(request);

		imageFilename = fileUpload.imageUpload(image).get(0);
		
		Lesson lesson = new Lesson();
		lesson.setLname(lname);
		lesson.setLprice(lprice);
		lesson.setImgurl(imageFilename);
		lesson.setQid(qid);
		lesson.setLdesc(ldesc);
		lesson.setCategory(category);

		lessonService.saveLesson(lesson, branchId);

		return "{\"result\":\"添加成功\"}";
	}
	
	@RequestMapping(value="/lesson/LessonHandler_updateLesson")
	@ResponseBody
	public String updateLesson(int lid, String lname, double lprice, String category, String ldesc, Integer[] branchId, @RequestParam MultipartFile[] image,
			 boolean imageChanged, String imageFilename,HttpServletRequest request)throws Exception{
		System.out.println("......LessonHandler......updateLesson()..........");
		String filename = imageFilename;
		FileUpload fileUpload = new FileUpload(request);
		
		if(imageChanged) {
			filename = fileUpload.imageUpload(image).get(0);
			List<String> tempList = new ArrayList();
			tempList.add(imageFilename);
			fileUpload.imageDelete(tempList);
		} else {
			filename = imageFilename.split("/")[3];
		}
		
		
		Lesson lesson = new Lesson();
		lesson.setLid(lid);
		lesson.setLname(lname);
		lesson.setLprice(lprice);
		lesson.setImgurl(filename);
		lesson.setLdesc(ldesc);
		lesson.setCategory(category);

		lessonService.updateLesson(lesson, branchId);
		
		return "{\"result\":\"编辑成功\"}";
	}
	
	@RequestMapping(value = "/lesson/LessonHandler_deleteLesson")
	@ResponseBody
	public String deleteLesson(int lid, HttpServletRequest request) throws Exception {
		System.out.println("......LessonHandler......deleteLesson()..........");
		Lesson lesson = lessonService.findLessonById(lid);
		
		FileUpload fileUpload = new FileUpload(request);
		List<String> tempList = new ArrayList();
		tempList.add(lesson.getImgurl());
		fileUpload.imageDelete(tempList);
		
		lessonService.deleteLesson(lid);

		return "{\"result\":\"删除成功\"}";
	}

}
