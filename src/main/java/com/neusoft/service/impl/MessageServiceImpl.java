package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Enterprise;
import com.neusoft.bean.EnterpriseBranch;
import com.neusoft.bean.Message;
import com.neusoft.bean.MessageImg;
import com.neusoft.bean.MessageLike;
import com.neusoft.bean.MessageReply;
import com.neusoft.bean.Swiper;
import com.neusoft.mapper.EnterpriseMapper;
import com.neusoft.mapper.MessageImgMapper;
import com.neusoft.mapper.MessageLikeMapper;
import com.neusoft.mapper.MessageMapper;
import com.neusoft.mapper.MessageReplyMapper;
import com.neusoft.mapper.SwiperMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.service.EnterpriseService;
import com.neusoft.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private MessageImgMapper messageImgMapper;
	@Autowired
	private MessageLikeMapper messageLikeMapper;
	@Autowired
	private MessageReplyMapper messageReplyMapper;
	@Autowired
	private SwiperMapper swiperMapper;

	@Override
	public List<Message> findAllMessage(int qid) throws Exception {
		System.out.println("......MessageService......findAllMessage()......");
		List<Message> messages = messageMapper.findAllMessage(qid);
		for(int i = 0; i < messages.size(); i++) {
			List<MessageImg> messageImgs;
			List<MessageLike> messageLikes;
			List<MessageReply> messageReplys;
			
			messageImgs = messageImgMapper.findMessageImgById(messages.get(i).getMid());
			messageLikes = messageLikeMapper.findMessageLikeById(messages.get(i).getMid());
			messageReplys = messageReplyMapper.findMessageReplyById(messages.get(i).getMid());
			
			messages.get(i).setMessageImgs(messageImgs);
			messages.get(i).setMessageLikes(messageLikes);
			messages.get(i).setMessageReplies(messageReplys);
		}
		return messages;
	}

	@Override
	public boolean saveMessage(Message message) throws Exception {
		messageMapper.saveMessage(message);
		List<MessageImg> messageImgs = message.getMessageImgs();
		for(int i = 0; i < messageImgs.size(); i++) {
			messageImgs.get(i).setMid(message.getMid());
			messageImgMapper.saveMessageImg(messageImgs.get(i));
		}
		return true;
	}
	
	@Override
	public boolean deleteMessage(int mid) throws Exception {
		messageMapper.deleteMessage(mid);
		
		return true;
	}

	@Override
	public Message findMessageById(int mid) throws Exception {
		Message message = messageMapper.findMessageById(mid);
		List<MessageImg> messageImgs;
		List<MessageLike> messageLikes;
		List<MessageReply> messageReplys;
		
		messageImgs = messageImgMapper.findMessageImgById(message.getMid());
		messageLikes = messageLikeMapper.findMessageLikeById(message.getMid());
		messageReplys = messageReplyMapper.findMessageReplyById(message.getMid());
		message.setMessageImgs(messageImgs);
		message.setMessageLikes(messageLikes);
		message.setMessageReplies(messageReplys);
		
		return message;
		
	}

	@Override
	public boolean updateMessage(Message message) throws Exception {
		messageMapper.updateMessage(message);
		List<MessageImg> messageImgs = message.getMessageImgs();
		messageImgMapper.deleteMessageImgByMessageId(message.getMid());
		for(int i = 0; i < messageImgs.size(); i++) {
			messageImgMapper.saveMessageImg(messageImgs.get(i));
		}
		return true;
	}

	@Override
	public boolean deleteComment(int id) throws Exception {
		messageReplyMapper.deleteComment(id);
		return true;
	}
	
	@Override
	public List<String> findImages(int qid) throws Exception {
		
		return swiperMapper.findMomentImages(qid);
	}
	
	@Override
	public boolean saveImages(int qid, List<Swiper> swipers) throws Exception {
		swiperMapper.deleteMomentImage(qid);
		for(Swiper s : swipers) {
			swiperMapper.saveMomentImage(s);
		}
		return true;
	}

}
