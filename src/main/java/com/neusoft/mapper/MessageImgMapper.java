package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;
import com.neusoft.bean.MessageImg;

public interface MessageImgMapper {
	public List<MessageImg> findMessageImgById(int mid) throws Exception;
	public int saveMessageImg(MessageImg messageImg) throws Exception;
	public int deleteMessageImgByMessageId(int mid) throws Exception;
}
