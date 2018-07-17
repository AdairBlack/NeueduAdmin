package com.neusoft.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Message {
	private Integer mid;
	private String mtitle;
	private Timestamp mtime;
	private Integer qid;
	
	List<MessageImg> messageImgs  = new ArrayList<MessageImg>();
	List<MessageReply> messageReplies = new ArrayList<MessageReply>();
	List<MessageLike> messageLikes = new ArrayList<MessageLike>();
	
	
	public List<MessageImg> getMessageImgs() {
		return messageImgs;
	}
	public void setMessageImgs(List<MessageImg> messageImgs) {
		this.messageImgs = messageImgs;
	}
	public List<MessageReply> getMessageReplies() {
		return messageReplies;
	}
	public void setMessageReplies(List<MessageReply> messageReplies) {
		this.messageReplies = messageReplies;
	}
	public List<MessageLike> getMessageLikes() {
		return messageLikes;
	}
	public void setMessageLikes(List<MessageLike> messageLikes) {
		this.messageLikes = messageLikes;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public Timestamp getMtime() {
		return mtime;
	}
	public void setMtime(Timestamp mtime) {
		this.mtime = mtime;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	} 

}
