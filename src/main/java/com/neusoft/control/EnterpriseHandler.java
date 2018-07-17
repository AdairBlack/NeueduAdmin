package com.neusoft.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.service.EnterpriseService;
import com.neusoft.tools.FileUpload;
import com.neusoft.tools.FilenameProcess;

@Controller
public class EnterpriseHandler {
	private static final String imagePath = "/upload/image/";
	private static final String videoPath = "/upload/video/";

	@Autowired
	private EnterpriseService enterpriseService;

	@RequestMapping(value = "/enterprise/EnterpriseHandler_findEnterpriseById")
	@ResponseBody
	public Enterprise findEnterpriseById(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......findEnterpriseById()..........");
		System.out.println("......" + this.toString() + "......");
		Enterprise enterprise = null;
		
		enterprise = enterpriseService.findEnterpriseById(qid);
		List<String> tempImageFilenames = new ArrayList();
		for(int i = 0; i < enterprise.getImageFilenames().size(); i++) {
			tempImageFilenames.add(imagePath + enterprise.getImageFilenames().get(i));
		}
		enterprise.setImageFilenames(tempImageFilenames);
		enterprise.setVideopath(videoPath + enterprise.getVideopath());
		return enterprise;
	}

	@RequestMapping(value = "/enterprise/EnterpriseHandler_updateEnterprise")
	@ResponseBody
	public String updateEnterprise(int qid, String name, String introduction, boolean imageChanged, boolean videoChanged,String[] imageFilenames, String videopath, @RequestParam MultipartFile[] images,
			@RequestParam MultipartFile[] video, String jczs, HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......updateEnterprise()......");
		List<String> imageList = new ArrayList();
		String videoName;
		FileUpload fileUpload = new FileUpload(request);
		
		if(imageChanged) {
			Enterprise enterprise = enterpriseService.findEnterpriseById(qid);
			imageList = fileUpload.imageUpload(images);
			enterpriseService.deleteOldImages(qid);
			fileUpload.imageDelete(enterprise.getImageFilenames());
		} else {
			for(int i = 0; i < imageFilenames.length; i++) {
				imageFilenames[i] = imageFilenames[i].split("/")[3];
				imageList.add(imageFilenames[i]);
			}
		}
		
		if(videoChanged) {
			videoName = fileUpload.videoUpload(video);
			Enterprise enterprise = enterpriseService.findEnterpriseById(qid);
			fileUpload.videoDelete(enterprise.getVideopath());
		} else {
			videopath = videopath.split("/")[3];
			videoName = videopath;
		}
		
		Enterprise enterprise = new Enterprise();
		enterprise.setQid(qid);
		enterprise.setName(name);
		enterprise.setIntroduction(introduction);
		enterprise.setImageFilenames(imageList);
		enterprise.setVideopath(videoName);
		enterprise.setJczs(jczs);

		enterpriseService.updateEnterprise(enterprise);

		return "{\"result\":\"编辑成功\"}";
	}

	/**
	 * CKEditor Image Upload
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/enterprise/EnterpriseHandler_saveEditorImage")
	@ResponseBody
	public String saveEditorImage(@RequestParam MultipartFile upload, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("......EnterpriseHandler......saveEditorImage()..........");
		
		String path = request.getServletContext().getRealPath("/");
		File f = new File(path);
		String serverPath = f.getParent();
		String imagePath = "/upload/image/";
		
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
		
		//Message sent to CKEdtior.
		String error = "{" +
			    "\"uploaded\": 0," +
			    "\"error\": {" +
			         "\"message\": \"Just test CKEditor error message.\"" +
			    "}" +
			    "}";
		String success = "{\"uploaded\": 1," +
			       "\"fileName\": \"" + filename + "\"," +
			       "\"url\": \"/upload/image/" + filename + "\"}";
		
		System.out.println("success : " + success);
		System.out.println("error : " + error);
		
		return success;
	}

	@RequestMapping(value = "/enterprise/EnterpriseHandler_findAllBranch")
	@ResponseBody
	public List<EnterpriseBranch> findAllBranch(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......findAllBranch()..........");

		List<EnterpriseBranch> enterpriseBranches = null;
		enterpriseBranches = enterpriseService.findAllBranch(qid);

		return enterpriseBranches;
	}
	
	@RequestMapping(value = "/enterprise/EnterpriseHandler_deleteBranch")
	@ResponseBody
	public String deleteBranch(int id, HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......deleteBranch()..........");
		enterpriseService.deleteBranch(id);

		return "{\"result\":\"删除成功\"}";
	}
	
	@RequestMapping(value = "/enterprise/EnterpriseHandler_findBranchById")
	@ResponseBody
	public EnterpriseBranch findBranchById(int id, HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......findBranchById()..........");
		

		return enterpriseService.findBranchById(id);
	}
	
	@RequestMapping(value = "/enterprise/EnterpriseHandler_updateBranch")
	@ResponseBody
	public String updateBranch(int id, String branch, String tel, String address, double longitude, double latitude,HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......updateBranch()..........");
		
		EnterpriseBranch enterpriseBranch = new EnterpriseBranch();
		enterpriseBranch.setId(id);
		enterpriseBranch.setBranch(branch);
		enterpriseBranch.setTel(tel);
		enterpriseBranch.setAddress(address);
		enterpriseBranch.setLongitude(longitude);
		enterpriseBranch.setLatitude(latitude);
		
		enterpriseService.updateBranch(enterpriseBranch);
		
		
		return "{\"result\":\"编辑成功\"}";
	}
	
	@RequestMapping(value = "/enterprise/EnterpriseHandler_saveBranch")
	@ResponseBody
	public String saveBranch(int qid, String branch, String tel, String address, double longitude, double latitude,HttpServletRequest request) throws Exception {
		System.out.println("......EnterpriseHandler......updateBranch()..........");
		
		EnterpriseBranch enterpriseBranch = new EnterpriseBranch();
		enterpriseBranch.setQid(qid);
		enterpriseBranch.setBranch(branch);
		enterpriseBranch.setTel(tel);
		enterpriseBranch.setAddress(address);
		enterpriseBranch.setLongitude(longitude);
		enterpriseBranch.setLatitude(latitude);
		
		enterpriseService.saveBranch(enterpriseBranch);
		
		
		return "{\"result\":\"保存成功\"}";
	}
}
