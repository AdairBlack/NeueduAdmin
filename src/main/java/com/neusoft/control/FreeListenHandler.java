package com.neusoft.control;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.bean.FreeListen;
import com.neusoft.mapper.FreeListenMapper;
import com.neusoft.service.FreeListenService;
import com.neusoft.tools.FileUpload;

@Controller
public class FreeListenHandler {
	private static final String imagePath = "/upload/image/";

	@Autowired
	private FreeListenService freeListenService;
	
	@RequestMapping(value="/freeListen/FreeListenHandler_findAll")
	@ResponseBody
	public List<FreeListen> findAll(int qid) throws Exception{
		System.out.println("......FreeListenHandler......findAll()..........");
		List<FreeListen> freeListens = freeListenService.findAll(qid);
		for(int i = 0; i < freeListens.size(); i++) {
			freeListens.get(i).setImgurl(imagePath + freeListens.get(i).getImgurl());
		}
		return freeListens;
	}
    
	@RequestMapping(value="/freeListen/FreeListenHandler_findFreeListenById")
	@ResponseBody
	public FreeListen findFreeListenById(int id) throws Exception{
		System.out.println("......FreeListenHandler......findFreeListenById()..........");
		FreeListen freeListen = freeListenService.findFreeListenById(id);
		freeListen.setImgurl(imagePath + freeListen.getImgurl());
		return freeListen;
	}
	
	@RequestMapping(value="/freeListen/FreeListenHandler_addFreeListen")
	@ResponseBody
	public String addFreeListen(String title,int branchId,String status, String fdesc, @RequestParam MultipartFile[] image, int qid,HttpServletRequest request) throws Exception{
		System.out.println("......FreeListenHandler......addFreeListen()..........");
		FileUpload fileUpload = new FileUpload(request);
		String imgurl = fileUpload.imageUpload(image).get(0);
		
		FreeListen freeListen = new FreeListen();
		freeListen.setTitle(title);
		freeListen.setQid(qid);
		freeListen.setImgurl(imgurl);
		freeListen.setStatus(status);
		freeListen.setFdesc(fdesc);
		freeListen.setBranchId(branchId);
		
		freeListenService.addFreeListen(freeListen);
		
		return "{\"result\":\"添加成功\"}";
	}
	
	@RequestMapping(value="/freeListen/FreeListenHandler_updateFreeListen")
	@ResponseBody
	public String updateFreeListen(String title,int branchId,String status, String fdesc, @RequestParam MultipartFile[] image, int id,
			 boolean imageChanged, String imageFilename,HttpServletRequest request) throws Exception{
		System.out.println("......FreeListenHandler......addFreeListen()..........");
		FileUpload fileUpload = new FileUpload(request);
		String imgurl;
		if(imageChanged) {
			imgurl = fileUpload.imageUpload(image).get(0);
		} else {
			imgurl = imageFilename.split("/")[3];
		}		
		FreeListen freeListen = new FreeListen();
		freeListen.setTitle(title);
		freeListen.setId(id);
		freeListen.setImgurl(imgurl);
		freeListen.setStatus(status);
		freeListen.setFdesc(fdesc);
		freeListen.setBranchId(branchId);
		
		freeListenService.updateFreeListen(freeListen);
		
		return "{\"result\":\"编辑成功\"}";
	}
	
	@RequestMapping(value = "/freeListen/FreeListenHandler_deleteFreeListen")
	@ResponseBody
	public String deleteLesson(int id, HttpServletRequest request) throws Exception {
		System.out.println("......FreeListenHandler......deleteFreeListen()..........");

		freeListenService.deleteFreeListen(id);

		return "{\"result\":\"删除成功\"}";
	}

}
