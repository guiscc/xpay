package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumNotifyType;

import java.math.BigDecimal;


/**
 * Created by suxinxin on 16/2/5.
 */
public class RefundCallBackReqDTO extends BaseQuickReqDTO {
	/**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 回调内容
     */
    private String callBackContent;
    /**
     * 通知类型
     */
    private EnumNotifyType notifyType;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
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
