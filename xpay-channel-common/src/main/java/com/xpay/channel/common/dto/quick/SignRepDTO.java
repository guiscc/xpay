package com.xpay.channel.common.dto.quick;

import com.xpay.channel.common.enums.EnumCardType;
import com.xpay.channel.common.enums.EnumCertType;
import com.xpay.channel.common.enums.EnumTradeStatus;

/**
 * 签约返回dto
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月2日 下午4:48:16
 */
public class SignRepDTO extends BaseQuickRepDTO {

    /**
     * 签约好
     */
    private String signNo;

    /**
     * 渠道签约好
     */
    private String channelSignNo;

    /**
     * 卡号
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
    private long amount;
    /**
     * 安全索引
     */
    private String securityIndex;
    /**
     * 卡索引
     */
    private String cardIndex;
    /**
     * 签约状态
     */
    private EnumTradeStatus tradeStatus;
	
	public String getChannelSignNo() {
		return channelSignNo;
	}
	public void setChannelSignNo(String channelSignNo) {
		this.channelSignNo = channelSignNo;
	}
	public String getSignNo() {
		return signNo;
	}
	public void setSignNo(String signNo) {
		this.signNo = signNo;
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
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
	public EnumTradeStatus getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(EnumTradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
    
    
}
