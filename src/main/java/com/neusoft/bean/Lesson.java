package com.neusoft.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lesson {
	private Integer lid;
	private String lname;
	private String imgurl;
	private Double lprice;
	private String ldesc;
	private String category;
	private Integer qid;
	private Timestamp pubtime;
	
	private List<EnterpriseBranch> branchs = new ArrayList<>();
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public Date getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		this.pubtime = new Timestamp(pubtime.getTime());
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public double getLprice() {
		return lprice;
	}
	public void setLprice(double lprice) {
		this.lprice = lprice;
	}
	public String getLdesc() {
		return ldesc;
	}
	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}
	public List<EnterpriseBranch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<EnterpriseBranch> branchs) {
		this.branchs = branchs;
	}

}
