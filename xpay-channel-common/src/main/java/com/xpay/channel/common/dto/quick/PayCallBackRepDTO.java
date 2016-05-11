package com.xpay.channel.common.dto.quick;

import java.math.BigDecimal;


/**
 * Created by suxinxin on 16/2/5.
 */
public class PayCallBackRepDTO extends BaseQuickRepDTO {
	/**
	 * 金额
	 */
	private BigDecimal amount ;
	
	/**
	 * 原请求支付单号
	 */
	private String oriPayNo ;
	
	/**
	 * 渠道支付单号
	 */
	private String oriChannelPayNo ;
	
	/**
	 * 返回结果
	 */
	private String responseBody ;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getOriPayNo() {
		return oriPayNo;
	}
	public void setOriPayNo(String oriPayNo) {
		this.oriPayNo = oriPayNo;
	}
	public String getOriChannelPayNo() {
		return oriChannelPayNo;
	}
	public void setOriChannelPayNo(String oriChannelPayNo) {
		this.oriChannelPayNo = oriChannelPayNo;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
