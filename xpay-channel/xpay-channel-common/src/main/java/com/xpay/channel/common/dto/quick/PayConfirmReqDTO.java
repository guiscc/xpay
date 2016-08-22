package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumCardType;
import com.xpay.channel.common.enums.EnumCertType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月3日 上午10:52:59
 */
public class PayConfirmReqDTO extends BaseQuickReqDTO {

    /**
     * 原请求签约号
     */
    private String oriSignNo ;
    
    /**
     * 银行签约号
     */
    private String oriChannelSignNo;
    
    /**
     * 请求支付单号
     */
    private String payNo ;

    /**
     * 渠道支付单号
     */
    private String channelPayNo;

    /**
     * quick用户ID
     */
    private String userId;

    /**
     * 卡类型
     */
    private EnumCardType cardType;

    /**
     * quick用户卡号
     */
    private String cardNo;

    /**
     * 证件类型
     */
    private EnumCertType certType;

    /**
     * 证件号
     */
    private String certCode;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 持卡人姓名
     */
    private String holderName;

    /**
     * 有效期
     */
    private String expireDate;

    /**
     * cvv2
     */
    private String cvv2;//quick 卡校验码，储蓄卡不用

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 短信验证
     */
    private String verifyCode;
    /**
     * 用户ip
     */
    private String userIp;
    /**
     * 备用字段
     */
    private Map<String,String> map = new HashMap<String,String>();
    private String securityIndex;
    private String cardIndex;
	public String getOriSignNo() {
		return oriSignNo;
	}
	public void setOriSignNo(String oriSignNo) {
		this.oriSignNo = oriSignNo;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getChannelPayNo() {
		return channelPayNo;
	}
	public void setChannelPayNo(String channelPayNo) {
		this.channelPayNo = channelPayNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public EnumCardType getCardType() {
		return cardType;
	}
	public void setCardType(EnumCardType cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getOriChannelSignNo() {
		return oriChannelSignNo;
	}
	public void setOriChannelSignNo(String oriChannelSignNo) {
		this.oriChannelSignNo = oriChannelSignNo;
	}
	public EnumCertType getCertType() {
		return certType;
	}
	public void setCertType(EnumCertType certType) {
		this.certType = certType;
	}
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public String getSecurityIndex() {
		return securityIndex;
	}
	public void setSecurityIndex(String securityIndex) {
		this.securityIndex = securityIndex;
	}
	public String getCardIndex() {
		return cardIndex;
	}
	public void setCardIndex(String cardIndex) {
		this.cardIndex = cardIndex;
	}
    
}
