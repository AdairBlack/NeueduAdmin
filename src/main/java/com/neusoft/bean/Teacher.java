package com.neusoft.bean;

public class Teacher {
	private int tid;
	private String introduction;
	private String tname;
	private String tphoto;
	private int qid;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTphoto() {
		return tphoto;
	}
	public void setTphoto(String tphoto) {
		this.tphoto = tphoto;
	}
}
