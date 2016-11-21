/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.common.enums.EnumPayStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: PayCallbackRepFrontDTO.java, v 0.1 16/10/17 下午2:05 sxfans Exp $
 */
public class PayCallbackRepFrontDTO extends BaseRepFrontDTO {

    private String        bankOrderNo;
    private String        bankNo;
    private Date          bankFinishDT;
    private EnumPayStatus payStatus;
    private BigDecimal    payAmt;

    /**
     * Getter method for property bankFinishDT.
     *
     * @return property value of bankFinishDT
     **/
    public Date getBankFinishDT() {
        return bankFinishDT;
    }

    /**
     * Setter method for property bankFinishDT.
     *
     * @param bankFinishDT value to be assigned to property bankFinishDT
     **/
    public void setBankFinishDT(Date bankFinishDT) {
        this.bankFinishDT = bankFinishDT;
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
     * Getter method for property bankNo.
     *
     * @return property value of bankNo
     **/
    public String getBankNo() {
        return bankNo;
    }

    /**
     * Setter method for property bankNo.
     *
     * @param bankNo value to be assigned to property bankNo
     **/
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
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
}