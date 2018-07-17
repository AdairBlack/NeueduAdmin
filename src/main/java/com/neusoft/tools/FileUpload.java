package com.neusoft.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private static final String imagePath = "/upload/image/";
	private static final String videoPath = "/upload/video/";
	private String serverPath;
	
	public FileUpload(HttpServletRequest request) {
		System.out.println("......FileUpload......FileUpload()......");
		String path = request.getServletContext().getRealPath("/");
		File f = new File(path);
		serverPath = f.getParent();
	}
	
	
//	for(MultipartFile mf : upload) {
//	String filename = System.currentTimeMillis() + mf.getOriginalFilename();
//	
//	//1.2. 文件传到哪 放在tomcat当前工程的同级目录下
//	String path = request.getServletContext().getRealPath("/");
//	File f = new File(path);
//	String ppath = f.getParent();
//
//	//1.3. 临时->目的
//		// mac:/   windows:\\
//	File dest = new File(ppath + File.separator + "upload", filename);
//
//	try {
//		mf.transferTo(dest);
//	}catch(Exception e) {
//		e.printStackTrace();
//	}
//}
	
	public List<String> imageUpload( @RequestParam MultipartFile[] images) throws Exception{
		System.out.println("......FileUpload......imageUpload()......");
		List<String> list = new ArrayList();
		for(MultipartFile mf : images) {
			
			String filename = System.currentTimeMillis() + mf.getOriginalFilename();
			
			//文件名中文及空格处理
			System.out.println("......Original Filename......");
			System.out.println(filename);
			
			FilenameProcess filenameProcess = new FilenameProcess();
			filename = filenameProcess.process(filename);
			
			
			System.out.println("......Processed Filename......");
			System.out.println(filename);
			
			File dest = new File(serverPath + imagePath, filename);
			list.add(filename);
			
			mf.transferTo(dest);
		}
		return list;
	}
	
	public String videoUpload( @RequestParam MultipartFile[] videos) throws Exception{
		System.out.println("......FileUpload......videoUpload()......");
		String video = null;
		for(MultipartFile mf : videos) {
			
			String filename = System.currentTimeMillis() + mf.getOriginalFilename();
			//文件名中文及空格处理
			System.out.println("......Original Filename......");
			System.out.println(filename);
			
			FilenameProcess filenameProcess = new FilenameProcess();
			filename = filenameProcess.process(filename);
			
			
			System.out.println("......Processed Filename......");
			System.out.println(filename);
			video = filename;
			File dest = new File(serverPath + videoPath, filename);
			
			mf.transferTo(dest);
		}
		return video;
	}
	
	public boolean imageDelete(List<String> filenames)  throws Exception{
		System.out.println("......FileUpload......imageDelete......");
		for(String filename : filenames) {
						
			File dest = new File(serverPath + imagePath, filename);
			if(dest.exists()) {
				dest.delete();
			}
			
			
		}
		return true;
	}
	
	public boolean videoDelete(String filename)  throws Exception{
		System.out.println("......FileUpload......videoDelete......");
						
		File dest = new File(serverPath + videoPath, filename);
		if(dest.exists()) {
			dest.delete();
		}
		
			
		return true;
	}


	public String getServerPath() {
		return serverPath;
	}


	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}


	public static String getImagepath() {
		return imagePath;
	}


	public static String getVideopath() {
		return videoPath;
	}
	
}
