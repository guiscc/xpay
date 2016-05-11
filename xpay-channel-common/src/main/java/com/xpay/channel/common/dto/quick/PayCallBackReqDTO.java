package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumNotifyType;


/**
 * Created by suxinxin on 16/2/5.
 */
public class PayCallBackReqDTO extends BaseQuickReqDTO {
	/**
	 * 交易金额
	 */
	private long amount ;
	/**
	 * 回调内容
	 */
	private String callBackContent ;

	/**
	 * 通知类型
	 */
	private EnumNotifyType notifyType ;

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCallBackContent() {
		return callBackContent;
	}

	public void setCallBackContent(String callBackContent) {
		this.callBackContent = callBackContent;
	}

	public EnumNotifyType getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(EnumNotifyType notifyType) {
		this.notifyType = notifyType;
	}
	
}
