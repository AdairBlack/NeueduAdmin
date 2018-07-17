package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;

public interface MessageMapper {
	public List<Message> findAllMessage(int qid) throws Exception;
	public int saveMessage(Message message) throws Exception;
	public int deleteMessage(int mid) throws Exception;
	public Message findMessageById(int mid) throws Exception;
	public int updateMessage(Message message) throws Exception;
}
