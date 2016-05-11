package com.xpay.channel.common.dto.quick;

import java.math.BigDecimal;

/**
 * 
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月3日 上午11:36:15
 */
public class PayConfirmRepDTO extends BaseQuickRepDTO {
	/**
     * 交易金额
     */
    private BigDecimal amount ;

    /**
     * 业务订单号
     */
    private String payNo ;

    /**
     * 路由订单号
     */
    private String channelPayNo ;

    /**
     * 商户号
     */
    private String merchantNo ;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
    
    
}
