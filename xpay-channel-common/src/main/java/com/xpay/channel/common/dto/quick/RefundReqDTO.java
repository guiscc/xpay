package com.xpay.channel.common.dto.quick;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by suxinxin on 16/2/5.
 */
public class RefundReqDTO extends BaseQuickReqDTO {
	/**
     * 渠道退款单号
     */
    private String channelRefundNo ;

    /**
     * 请求退款单号
     */
    private String refundNo ;

    /**
     * 退款金额
     */
    private BigDecimal amount;
    /**
     * 原支付金额
     */
    private BigDecimal oriPayAmount ;

    /**
     * 支付完成时间
     */
    private Date channelPayFinishTime;
    /**
     * 退款单创建时间
     */
    private Date channelCreateTime ;
    
    /**
     * 原交易单创建时间
     */
    private Date oriChannelPayCreateTime ;
    
    /**
     * 原支付单号
     */
    private String oriChannelPayNo;
    /**
     * 原支付银行返回流水号
     */
    private String oriBankNo;
    /**
     * 退款原支付业务单号
     */
    private String oriPayNo;
    /**
     * 用户ip
     */
    private String userIp;
    /**
     * 用户id
     */
    private String userId;
	public String getChannelRefundNo() {
		return channelRefundNo;
	}
	public void setChannelRefundNo(String channelRefundNo) {
		this.channelRefundNo = channelRefundNo;
	}
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getOriPayAmount() {
		return oriPayAmount;
	}
	public void setOriPayAmount(BigDecimal oriPayAmount) {
		this.oriPayAmount = oriPayAmount;
	}
	public Date getOriChannelPayCreateTime() {
		return oriChannelPayCreateTime;
	}
	public void setOriChannelPayCreateTime(Date oriChannelPayCreateTime) {
		this.oriChannelPayCreateTime = oriChannelPayCreateTime;
	}
	public Date getChannelPayFinishTime() {
		return channelPayFinishTime;
	}
	public void setChannelPayFinishTime(Date channelPayFinishTime) {
		this.channelPayFinishTime = channelPayFinishTime;
	}
	public Date getChannelCreateTime() {
		return channelCreateTime;
	}
	public void setChannelCreateTime(Date channelCreateTime) {
		this.channelCreateTime = channelCreateTime;
	}
	public String getOriChannelPayNo() {
		return oriChannelPayNo;
	}
	public void setOriChannelPayNo(String oriChannelPayNo) {
		this.oriChannelPayNo = oriChannelPayNo;
	}
	public String getOriBankNo() {
		return oriBankNo;
	}
	public void setOriBankNo(String oriBankNo) {
		this.oriBankNo = oriBankNo;
	}
	public String getOriPayNo() {
		return oriPayNo;
	}
	public void setOriPayNo(String oriPayNo) {
		this.oriPayNo = oriPayNo;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}
