/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.common.enums.EnumRefundStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: RefundCallbackRepFrontDTO.java, v 0.1 16/10/17 下午2:08 sxfans Exp $
 */
public class RefundCallbackRepFrontDTO extends BaseRepFrontDTO {

    private String bankOrderNo;

    private String bankRefundNo;

    private Date bankFinishDT;

    private EnumRefundStatus refundStatus;

    private BigDecimal refundAmt;

    /**
     * Getter method for property bankOrderNo.
     *
     * @return property value of bankOrderNo
     **/
    public String getBankOrderNo() {
        return bankOrderNo;
    }

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
     * Setter method for property bankOrderNo.
     *
     * @param bankOrderNo value to be assigned to property bankOrderNo
     **/
    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo;
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
     * Setter method for property refundAmt.
     *
     * @param refundAmt value to be assigned to property refundAmt
     **/
    public void setRefundAmt(BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }

    /**
     * Getter method for property refundStatus.
     *
     * @return property value of refundStatus
     **/
    public EnumRefundStatus getRefundStatus() {
        return refundStatus;
    }

    /**
     * Setter method for property refundStatus.
     *
     * @param refundStatus value to be assigned to property refundStatus
     **/
    public void setRefundStatus(EnumRefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

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
}