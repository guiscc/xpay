package com.xpay.channel.common.dto.quick;

import java.math.BigDecimal;

/**
 * 
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月3日 下午2:33:24
 */
public class RefundRepDTO extends BaseQuickRepDTO {/**
     * 退款金额
     */
    private BigDecimal amount;
    /**
     * 退款订单号
     */
    private String channelRefundNo;
    /**
     * 原支付订单号
     */
    private String oriChannelPayNo;
    /**
     * 请求退款单号
     */
    private String refundNo;
    /**
     * 原支付请求单号
     */
    private String oriPayNo;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getChannelRefundNo() {
		return channelRefundNo;
	}
	public void setChannelRefundNo(String channelRefundNo) {
		this.channelRefundNo = channelRefundNo;
	}
	public String getOriChannelPayNo() {
		return oriChannelPayNo;
	}
	public void setOriChannelPayNo(String oriChannelPayNo) {
		this.oriChannelPayNo = oriChannelPayNo;
	}
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public String getOriPayNo() {
		return oriPayNo;
	}
	public void setOriPayNo(String oriPayNo) {
		this.oriPayNo = oriPayNo;
	}
}
