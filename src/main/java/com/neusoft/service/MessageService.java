package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;
import com.neusoft.bean.Swiper;

public interface MessageService {
	public List<Message> findAllMessage(int qid) throws Exception;
	public boolean saveMessage(Message message) throws Exception;
	public boolean deleteMessage(int mid) throws Exception;
	public Message findMessageById(int mid) throws Exception;
	public boolean updateMessage(Message message) throws Exception;
	public boolean deleteComment(int id) throws Exception;
	public List<String> findImages(int qid) throws Exception;
	public boolean saveImages(int qid,List<Swiper> swipers) throws Exception;
}
