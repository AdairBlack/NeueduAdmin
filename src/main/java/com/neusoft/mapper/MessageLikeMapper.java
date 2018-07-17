package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;
import com.neusoft.bean.MessageLike;

public interface MessageLikeMapper {
	public List<MessageLike> findMessageLikeById(int mid) throws Exception;
}
