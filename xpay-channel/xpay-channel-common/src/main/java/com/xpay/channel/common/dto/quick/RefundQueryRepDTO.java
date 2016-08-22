package com.xpay.channel.common.dto.quick;

import java.math.BigDecimal;

/**
 * @desc see class name
 * @author pangyiyang
 * @time 2016年2月29日 下午4:09:17
 */
public class RefundQueryRepDTO extends BaseQuickRepDTO {
	/**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 原银行订单号
     */
    private String oriRefundNo;

    /**
     * 原业务订单号
     */
    private String oriChannelRefundNo;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOriRefundNo() {
		return oriRefundNo;
	}

	public void setOriRefundNo(String oriRefundNo) {
		this.oriRefundNo = oriRefundNo;
	}

	public String getOriChannelRefundNo() {
		return oriChannelRefundNo;
	}

	public void setOriChannelRefundNo(String oriChannelRefundNo) {
		this.oriChannelRefundNo = oriChannelRefundNo;
	}
    
}
