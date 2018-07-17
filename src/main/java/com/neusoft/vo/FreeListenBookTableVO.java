package com.neusoft.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.neusoft.bean.FreeListen;

import javafx.scene.input.DataFormat;

public class FreeListenBookTableVO {
	private Integer id;
	private Integer fid;
	private String username;
	private Long tel;
	private String title;
	private String booktime;
	private String comment;
	private String status;
	private String openid;
	private Integer qid;
	private String manipulate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		if(!status.equals("已处理"))
			//this.manipulate = "<a href = \"javascript:manipulateBook("+id+")\">处理</a>";
			this.manipulate = "<button type='button' class='layui-btn layui-btn-ptimary layui-btn-sm' onclick='manipulateBook("+id+")'>处理</button>";
		else
			this.manipulate = null;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getQid() {
		return qid;
	}
	public String getManipulate() {
		return manipulate;
	}
	public void setManipulate(String manipulate) {
		this.manipulate = manipulate;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getBooktime() {
		return booktime;
	}
	public void setBooktime(Timestamp booktime) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.booktime = dataFormat.format(booktime);
	}

}
