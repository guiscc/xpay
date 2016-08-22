package com.xpay.channel.common.dto.quick;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by suxinxin on 16/2/5.
 */
public class SignConfirmReqDTO extends BaseQuickReqDTO {

	private String orderNo;// 支付订单号
	private String cardNo;// 认证项：银行卡号 密文，银行卡号，与银行卡类型成对出现
	private String mobileNo;// 认证项：银行预留手机号 密文，银行柜面预留手机号
	private String userId;// 用户id
	private String vaildCode;// 手机验证码
	private String token;// 手机动态指令

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVaildCode() {
		return vaildCode;
	}

	public void setVaildCode(String vaildCode) {
		this.vaildCode = vaildCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
