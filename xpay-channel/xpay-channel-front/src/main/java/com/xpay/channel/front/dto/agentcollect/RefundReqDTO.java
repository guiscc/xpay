/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseReqDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: RefundReqDTO.java, v 0.1 16/10/17 下午2:04 sxfans Exp $
 */
public class RefundReqDTO extends BaseReqDTO {

    /**
     * 银行订单号
     */
    private String     bankOrderNo;

    /**
     * 退款订单号
     */
    private String     bankRefundNo;

    /**
     * 退款金额
     */
    private BigDecimal refundAmt;

    /**
     * 支付日期
     */
    private Date       payDateTime;

    /**
     * Getter method for property bankRefundNo.
     *
     * @return property value of bankRefundNo
     **/
    public String getBankRefundNo() {
        return bankRefundNo;
    }

    /**
     * Setter method for property bankRefundNo.
     *
     * @param bankRefundNo value to be assigned to property bankRefundNo
     **/
    public void setBankRefundNo(String bankRefundNo) {
        this.bankRefundNo = bankRefundNo;
    }

    /**
     * Getter method for property payDateTime.
     *
     * @return property value of payDateTime
     **/
    public Date getPayDateTime() {
        return payDateTime;
    }

    /**
     * Setter method for property payDateTime.
     *
     * @param payDateTime value to be assigned to property payDateTime
     **/
    public void setPayDateTime(Date payDateTime) {
        this.payDateTime = payDateTime;
    }

    /**
     * Getter method for property refundAmt.
     *
     * @return property value of refundAmt
     **/
    public BigDecimal getRefundAmt() {
        return refundAmt;
    }

    /**
     * Getter method for property bankOrderNo.
     *
     * @return property value of bankOrderNo
     **/
    public String getBankOrderNo() {
        return bankOrderNo;
    }

    /**
     * Setter method for property bankOrderNo.
     *
     * @param bankOrderNo value to be assigned to property bankOrderNo
     **/
    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo;
    }

    /**
     * Setter method for property refundAmt.
     *
     * @param refundAmt value to be assigned to property refundAmt
     **/
    public void setRefundAmt(BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }
}