/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto;

import com.xpay.common.enums.EnumPayStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author qinshou
 * @version $Id: PayOrderDTO.java, v 0.1 16/9/15 下午9:40 sxfans Exp $
 */
public class PayOrderDTO implements Serializable{
    /**
     * 交易单号
     */
    private String tradeOrderNo;

    /**
     * 支付单号
     */
    private String payOrderNo;

    /**
     * 付款金额
     */
    private BigDecimal payAmt;

    /**
     * 支付状态
     */
    private EnumPayStatus payStatus;


    /**
     * Getter method for property tradeOrderNo.
     *
     * @return property value of tradeOrderNo
     **/
    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    /**
     * Setter method for property tradeOrderNo.
     *
     * @param tradeOrderNo value to be assigned to property tradeOrderNo
     **/
    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    /**
     * Getter method for property payOrderNo.
     *
     * @return property value of payOrderNo
     **/
    public String getPayOrderNo() {
        return payOrderNo;
    }

    /**
     * Setter method for property payOrderNo.
     *
     * @param payOrderNo value to be assigned to property payOrderNo
     **/
    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    /**
     * Getter method for property payAmt.
     *
     * @return property value of payAmt
     **/
    public BigDecimal getPayAmt() {
        return payAmt;
    }

    /**
     * Setter method for property payAmt.
     *
     * @param payAmt value to be assigned to property payAmt
     **/
    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    /**
     * Getter method for property payStatus.
     *
     * @return property value of payStatus
     **/
    public EnumPayStatus getPayStatus() {
        return payStatus;
    }

    /**
     * Setter method for property payStatus.
     *
     * @param payStatus value to be assigned to property payStatus
     **/
    public void setPayStatus(EnumPayStatus payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}