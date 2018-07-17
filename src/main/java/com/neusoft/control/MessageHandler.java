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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;
import com.neusoft.bean.MessageImg;
import com.neusoft.bean.Swiper;
import com.neusoft.service.EnterpriseService;
import com.neusoft.service.MessageService;
import com.neusoft.tools.FileUpload;

@Controller
public class MessageHandler {
	private static final String imagePath = "/upload/image/";

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/message/MessageHandler_findAllMessage")
	@ResponseBody
	public List<Message> findAllMessage(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......findAllMessage()......");
		List<Message> messages = messageService.findAllMessage(qid);
		for(int i = 0; i < messages.size(); i++) {
			List<MessageImg> messageImgs = messages.get(i).getMessageImgs();
			for(int j = 0; j < messageImgs.size(); j++) {
				messageImgs.get(j).setImgurl(imagePath + messageImgs.get(j).getImgurl());
			}
		}
		return messages;
	}
	
	@RequestMapping(value = "/message/MessageHandler_findMessageById")
	@ResponseBody
	public Message findMessageById(int mid, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......findMessageById()......");
		
		Message message = messageService.findMessageById(mid);
		List<MessageImg> messageImgs = message.getMessageImgs();
		for(int j = 0; j < messageImgs.size(); j++) {
			messageImgs.get(j).setImgurl(imagePath + messageImgs.get(j).getImgurl());
		}
		
		return message;
	}
	
	@RequestMapping(value = "/message/MessageHandler_saveMessage")
	@ResponseBody
	public String saveMessage(int qid, String mtitle, @RequestParam MultipartFile[] images, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......saveMessage()......");
		FileUpload fileUpload = new FileUpload(request);
		List<String> imageList;
		imageList = fileUpload.imageUpload(images);
		List<MessageImg> messageImgs = new ArrayList();
		
		for(int i = 0; i < imageList.size(); i++) {
			MessageImg messageImg = new MessageImg();
			messageImg.setImgurl(imageList.get(i));
			messageImgs.add(messageImg);
		}
		
		Message message = new Message();
		message.setMessageImgs(messageImgs);
		message.setMtitle(mtitle);
		message.setQid(qid);
		
		messageService.saveMessage(message);

		return "{\"result\":\"发送成功\"}";
	}
	
	@RequestMapping(value = "/message/MessageHandler_deleteMessage")
	@ResponseBody
	public String deleteMessage(int mid, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......deleteMessage()......");
		
		FileUpload fileUpload = new FileUpload(request);
		Message message = messageService.findMessageById(mid);
		List<String> deleteList = new ArrayList<>();
		for(int i = 0; i < message.getMessageImgs().size(); i++) {
			deleteList.add(message.getMessageImgs().get(i).getImgurl());
		}
		fileUpload.imageDelete(deleteList);
		
		messageService.deleteMessage(mid);
		
		return "{\"result\":\"删除成功\"}";
	}
	
	@RequestMapping(value = "/message/MessageHandler_updateMessage")
	@ResponseBody
	public String updateMessage(int mid, String mtitle, @RequestParam MultipartFile[] images, 
			boolean imageChanged, String[] messageImgFiles, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......updateMessage()......");
		
		
		FileUpload fileUpload = new FileUpload(request);
		List<MessageImg> messageImgs = new ArrayList();
		
		if(imageChanged) {
			List<String> imageList;
			imageList = fileUpload.imageUpload(images);
			
			for(int i = 0; i < imageList.size(); i++) {
				MessageImg messageImg = new MessageImg();
				messageImg.setMid(mid);
				messageImg.setImgurl(imageList.get(i));
				messageImgs.add(messageImg);
			}
			
			List<String> deleteList = new ArrayList<>();
			for(int i = 0; i < messageImgFiles.length; i++) {
				deleteList.add(messageImgFiles[i].split("/")[3]);
			}
			fileUpload.imageDelete(deleteList);
			
		} else {
			
			for(int i = 0; i < messageImgFiles.length; i++) {
				MessageImg messageImg = new MessageImg();
				messageImg.setImgurl(messageImgFiles[i]);
				messageImg.setMid(mid);
				messageImg.setImgurl(messageImg.getImgurl().split("/")[3]);
				messageImgs.add(messageImg);
			}
		}
		
		Message message = new Message();
		message.setMessageImgs(messageImgs);
		message.setMtitle(mtitle);
		message.setMid(mid);
		messageService.updateMessage(message);

		return "{\"result\":\"编辑成功\"}";
	}
	
	@RequestMapping(value = "/message/MessageHandler_deleteComment")
	@ResponseBody
	public String deleteComment(int id, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......deleteComment()......");
		messageService.deleteComment(id);
		
		return "{\"result\":\"删除成功\"}";
	}
	
	@RequestMapping(value = "/message/MessageHandler_findImages")
	@ResponseBody
	public List<String> findImages(int qid, HttpServletRequest request) throws Exception {
		System.out.println("......TeacherHandler......findImages()..........");
		List<String> list = messageService.findImages(qid);
		for(int i = 0; i < list.size(); i++) {
			list.set(i, imagePath + list.get(i));
		}
		return list;
	}
	
	@RequestMapping(value = "/message/MessageHandler_saveImages")
	@ResponseBody
	public String saveImages(int qid, boolean imageChanged, String[] imageFilenames, @RequestParam MultipartFile[] images, HttpServletRequest request) throws Exception {
		System.out.println("......MessageHandler......saveImages()..........");
		List<String> filenames;
		List<Swiper> swipers = new ArrayList();
		
		FileUpload fileUpload = new FileUpload(request);
		
		
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
		
		messageService.saveImages(qid, swipers);
		
		
		return "{\"result\":\"保存成功\"}";
	}
}
