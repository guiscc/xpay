package com.xpay.channel.common.dto.quick;

import java.util.Date;


/**
 * Created by suxinxin on 16/2/5.
 */
public class CheckFileReqDTO extends BaseQuickReqDTO {
	/**
     * 请求序列号
     */
    private String reqNo;

    /**
     * 对账日期
     */
    private Date checkDate;


    /**
     * 银行商户号
     */
    private String merchantNo;


	public String getReqNo() {
		return reqNo;
	}


	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}


	public Date getCheckDate() {
		return checkDate;
	}


	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}


	public String getMerchantNo() {
		return merchantNo;
	}


	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
    
}
