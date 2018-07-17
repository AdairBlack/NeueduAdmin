package com.neusoft.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FreeListen {
	private int id;
	private String title;
	private String imgurl;
	private String status;
	private String pubtime;
	private int branchId;
	private int qid;
	private String fdesc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.pubtime = dateFormat.format(pubtime);
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
}
