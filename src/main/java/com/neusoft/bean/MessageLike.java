package com.neusoft.bean;

import java.sql.Timestamp;

public class MessageLike {
	private Integer id;
	private Integer mid;
	private String nickname;
	private Timestamp stime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}

}
