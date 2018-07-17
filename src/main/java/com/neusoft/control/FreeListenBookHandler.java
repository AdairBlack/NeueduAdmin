package com.neusoft.control;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neusoft.bean.FreeListenBook;
import com.neusoft.service.FreeListenBookService;
import com.neusoft.vo.FreeListenBookTableVO;

@Controller
public class FreeListenBookHandler {
	
	@Autowired
	private FreeListenBookService freeListenBookService;
	
	@RequestMapping("/freeListenBook/FreeListenBookHandler_findAll")
	@ResponseBody
	public String findAll(Integer qid) throws SQLException{
		System.out.println("............FreeListenBookHandler_findAll..............");
		List<FreeListenBook> books = freeListenBookService.findAll(qid);
		List<FreeListenBookTableVO> bookTableVOs = new ArrayList<FreeListenBookTableVO>();
		for(FreeListenBook book:books) {
			bookTableVOs.add(book.getFreeListenBookTableVO());
		}
		Gson gson = new Gson();
		String toReturn ="{\"code\":0,\"msg\":\"\",\"count\":"+books.size()+",\"data\":";
		String booksJson = gson.toJson(bookTableVOs);
		System.out.println(toReturn+booksJson+"}");
		return toReturn+booksJson+"}";
				
	}
	@RequestMapping("/freeListenBook/FreeListenBookHandler_findOrderByPage")
	@ResponseBody
	public String findAllByPage(int qid, int page, int limit) throws SQLException{
		System.out.println("............FreeListenBookHandler_findOrderByPage..............");
		List<FreeListenBook> books = freeListenBookService.findAllByPage(qid, page, limit);
		
		System.out.println("......" + page + "......");
		System.out.println("......" + limit + "......");
		
		List<FreeListenBook> allBooks = freeListenBookService.findAll(qid);
		
		List<FreeListenBookTableVO> bookTableVOs = new ArrayList<FreeListenBookTableVO>();
		for(FreeListenBook book:books) {
			bookTableVOs.add(book.getFreeListenBookTableVO());
		}
		Gson gson = new Gson();
		String toReturn ="{\"code\":0,\"msg\":\"\",\"count\":"+ allBooks.size() +",\"data\":";
		String booksJson = gson.toJson(bookTableVOs);
		System.out.println(toReturn+booksJson+"}");
		return toReturn+booksJson+"}";
				
	}
	
	
	
	@RequestMapping("/freeListenBook/FreeListenBookHandler_findSome")
	@ResponseBody
	public String findSome(int qid,String name,String keyword,String status,HttpServletRequest request) throws SQLException{
		System.out.println("............FreeListenBookHandler_findSome..............");
		Map map = new HashMap<>();
		map.put("qid", qid);
		map.put("username", name);
		if(!("NaN".equals(request.getParameter("fromDate"))))
			map.put("fromDate", new Timestamp(Long.valueOf(request.getParameter("fromDate"))));
		else
			map.put("fromDate", null);
		if(!("NaN".equals(request.getParameter("toDate"))))
			map.put("toDate", new Timestamp(Long.valueOf(request.getParameter("toDate"))));
		else
			map.put("toDate", null);
		map.put("keyword", keyword);
		map.put("status", status);
		List<FreeListenBook> books = freeListenBookService.findSome(map);
		List<FreeListenBookTableVO> bookTableVOs = new ArrayList<FreeListenBookTableVO>();
		for(FreeListenBook book:books) {
			bookTableVOs.add(book.getFreeListenBookTableVO());
		}
		if(books.size()>0) {
			Gson gson = new Gson();
			String toReturn ="{\"code\":0,\"msg\":\"\",\"count\":"+books.size()+",\"data\":";
			String booksJson = gson.toJson(bookTableVOs);
			System.out.println(toReturn+booksJson+"}");
			return toReturn+booksJson+"}";
		}
		else
			return null;
				
	}
	
	@RequestMapping("/freeListenBook/FreeListenBookHandler_findSomeByPage")
	@ResponseBody
	public String findSomeByPage(int qid, int page, int limit,String name,String keyword,String status,HttpServletRequest request) throws SQLException{
		System.out.println("............FreeListenBookHandler_findSome..............");
		Map map = new HashMap<>();
		map.put("qid", qid);
		map.put("username", name);
		if(!("NaN".equals(request.getParameter("fromDate"))))
			map.put("fromDate", new Timestamp(Long.valueOf(request.getParameter("fromDate"))));
		else
			map.put("fromDate", null);
		if(!("NaN".equals(request.getParameter("toDate"))))
			map.put("toDate", new Timestamp(Long.valueOf(request.getParameter("toDate"))));
		else
			map.put("toDate", null);
		map.put("keyword", keyword);
		
		//(page - 1) * limit
		map.put("startPage", (page - 1) * limit);
		map.put("limit", limit);
		map.put("status", status);
		List<FreeListenBook> books = freeListenBookService.findSomeByPage(map);
		List<FreeListenBookTableVO> bookTableVOs = new ArrayList<FreeListenBookTableVO>();
		for(FreeListenBook book:books) {
			bookTableVOs.add(book.getFreeListenBookTableVO());
		}
		if(books.size()>0) {
			Gson gson = new Gson();
			String toReturn ="{\"code\":0,\"msg\":\"\",\"count\":"+freeListenBookService.countFindSome(map)+",\"data\":";
			String booksJson = gson.toJson(bookTableVOs);
			System.out.println(toReturn+booksJson+"}");
			return toReturn+booksJson+"}";
		}
		else
			return null;
				
	}
	
	@RequestMapping("/freeListenBook/FreeListenBookHandler_manipulate")
	@ResponseBody
	public String manipulateBook(Integer bookId,Integer qid) throws SQLException{
		freeListenBookService.manipulateBook(bookId);
		System.out.println("............FreeListenBookHandler_manipulate..............");
		List<FreeListenBook> books = freeListenBookService.findAll(qid);
		System.out.println("books size:"+books.size());
		List<FreeListenBookTableVO> bookTableVOs = new ArrayList<FreeListenBookTableVO>();
		for(FreeListenBook book:books) {
			bookTableVOs.add(book.getFreeListenBookTableVO());
		}
		Gson gson = new Gson();
		String toReturn ="{\"code\":0,\"msg\":\"\",\"count\":"+books.size()+",\"data\":";
		String booksJson = gson.toJson(bookTableVOs);
		System.out.println(toReturn+booksJson+"}");
		return toReturn+booksJson+"}";	
	}

}
