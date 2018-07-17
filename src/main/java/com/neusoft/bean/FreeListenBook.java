package com.neusoft.bean;

import java.sql.Timestamp;

import com.neusoft.vo.FreeListenBookTableVO;

public class FreeListenBook {
	private Integer id;
	private Integer fid;
	private String username;
	private Long tel;
	private Timestamp booktime;
	private String status;
	private String comment;
	private String openid;
	
	private FreeListen freeListen = new FreeListen();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getBooktime() {
		return booktime;
	}
	public void setBooktime(Timestamp booktime) {
		this.booktime = booktime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public FreeListenBookTableVO getFreeListenBookTableVO() {
		FreeListenBookTableVO vo = new FreeListenBookTableVO();
		vo.setBooktime(booktime);
		vo.setComment(comment);
		vo.setFid(fid);
		vo.setId(id);
		vo.setOpenid(openid);
		vo.setStatus(status);
		vo.setTel(tel);
		vo.setTitle(freeListen.getTitle());
		vo.setUsername(username);
		vo.setQid(freeListen.getQid());
		return vo;
	}
	public FreeListen getFreeListen() {
		return freeListen;
	}
	public void setFreeListen(FreeListen freeListen) {
		this.freeListen = freeListen;
	}

}
