package com.neusoft.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.neusoft.bean.Order;

public class OrderTableVO {
	private Integer lid;
	private Integer oid;
	private String nickname;
	private Long tel;
	private Double total;
	private Integer cid;
	private Double actual;
	private String status;
	private String manipulate;
	private String orderTime;
	private String transactionId;
	public OrderTableVO(Order order) {
		setActual(order.getActual());
		setCid(order.getCid());
		setOid(order.getOid());
		setLid(order.getLid());
		setNickname(order.getNickname());
		setStatus(order.getStatus());
		setTransactionId(order.getTransactionId());
		setTotal(order.getTotal());
		setTel(order.getTel());
		setOrderTime(order.getOrderTime());
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		if(!"已核销".equals(status))
			this.manipulate = "<button type='button' class='layui-btn layui-btn-ptimary layui-btn-sm' onclick='manipulateBook("+oid+")'>核销</button>";
			//this.manipulate = "<a href = \"javascript:manipulateBook("+oid+")\">核销</a>";
		this.oid = oid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Double getActual() {
		return actual;
	}
	public void setActual(Double actual) {
		this.actual = actual;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getManipulate() {
		return manipulate;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.orderTime = dateFormat.format(orderTime);
	}
	public void setManipulate(String manipulate) {
		this.manipulate = manipulate;
	}
	

}
