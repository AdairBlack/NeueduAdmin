package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;
import com.neusoft.bean.MessageReply;

public interface MessageReplyMapper {
	public List<MessageReply> findMessageReplyById(int mid) throws Exception;
	public int deleteComment(int id) throws Exception;
}
