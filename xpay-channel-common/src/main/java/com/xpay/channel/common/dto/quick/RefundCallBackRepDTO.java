package com.xpay.channel.common.dto.quick;

import java.math.BigDecimal;


/**
 * Created by suxinxin on 16/2/5.
 */
public class RefundCallBackRepDTO extends BaseQuickRepDTO {
	/**
     * 网关支付流水号
     */
	private String oriChannelPayNo;
	
	/**
     * 网关支付返回流水号
     */
	private String oriBankNo;
	
	/**
     * 网关退货流水号
     */
	private String channelRefundNo;

	/**
	 * 原退款业务订单号
	 */

	private String oriRefundNo;

	/**
	 * 商户号
	 */
	private String merhcantNo;
	
    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 返回报文信息
     */
    private String responseBody;

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

	public String getChannelRefundNo() {
		return channelRefundNo;
	}

	public void setChannelRefundNo(String channelRefundNo) {
		this.channelRefundNo = channelRefundNo;
	}

	public String getOriRefundNo() {
		return oriRefundNo;
	}

	public void setOriRefundNo(String oriRefundNo) {
		this.oriRefundNo = oriRefundNo;
	}

	public String getMerhcantNo() {
		return merhcantNo;
	}

	public void setMerhcantNo(String merhcantNo) {
		this.merhcantNo = merhcantNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
    
}
