package com.neusoft.vo;

import java.text.SimpleDateFormat;

import com.neusoft.bean.Refund;

public class RefundVO extends Refund {
	private String manipulate;
	private String refundTimeString;
	public RefundVO(Refund refund) {
		setOid(refund.getOid());
		setRefundReason(refund.getRefundReason());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		setRefundTimeString(dateFormat.format(refund.getRefundTime()));
		setStatus(refund.getStatus());
		if("待处理".equals(refund.getStatus()))
			setManipulate("<button type='button' class='layui-btn layui-btn-ptimary layui-btn-sm' onclick='manipulateBook("+refund.getOid()+")'>确认退款</button>");
	}

	public String getManipulate() {
		return manipulate;
	}

	public void setManipulate(String manipulate) {
		this.manipulate = manipulate;
	}

	public String getRefundTimeString() {
		return refundTimeString;
	}

	public void setRefundTimeString(String refundTimeString) {
		this.refundTimeString = refundTimeString;
	}
}
