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
 * @version $Id: ACQueryPayRepFrontFrontDTO.java, v 0.1 16/10/17 下午2:03 sxfans Exp $
 */
public class ACQueryPayRepFrontFrontDTO extends BaseRepFrontDTO {

    private String        bankOrderNo;
    private String        bankNo;
    private BigDecimal    payAmt;
    private EnumPayStatus payStatus;
    private Date          bankFinishTime;

    /**
     * Getter method for property bankFinishTime.
     *
     * @return property value of bankFinishTime
     **/
    public Date getBankFinishTime() {
        return bankFinishTime;
    }

    /**
     * Setter method for property bankFinishTime.
     *
     * @param bankFinishTime value to be assigned to property bankFinishTime
     **/
    public void setBankFinishTime(Date bankFinishTime) {
        this.bankFinishTime = bankFinishTime;
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
}