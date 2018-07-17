package com.neusoft.bean;

import java.sql.Timestamp;

public class Refund {
	private Integer oid;
	private String refundReason;
	private Timestamp refundTime;
	private String status;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public Timestamp getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(Timestamp refundTime) {
		this.refundTime = refundTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
