package com.neusoft.vo;

import java.sql.Timestamp;
import java.util.List;

import com.neusoft.bean.Order;

public class LessonDataVo {
	private Integer lid;
	private String lname;
	private String imgurl;
	private Double lprice;
	private String ldesc;
	private String category;
	private Integer qid;
	private Timestamp pubtime;
	private List<Order> orders;
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Double getLprice() {
		return lprice;
	}
	public void setLprice(Double lprice) {
		this.lprice = lprice;
	}
	public String getLdesc() {
		return ldesc;
	}
	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public Timestamp getPubtime() {
		return pubtime;
	}
	public void setPubtime(Timestamp pubtime) {
		this.pubtime = pubtime;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
