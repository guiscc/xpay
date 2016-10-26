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
 * @version $Id: RefundRepFrontFrontDTO.java, v 0.1 16/10/17 下午2:04 sxfans Exp $
 */
public class RefundRepFrontFrontDTO extends BaseRepFrontDTO {

    /**
     * 银行退款单号
     */
    private String bankRefundNo;

    /**
     * 退款金额
     */
    private BigDecimal refundAmt;

    /**
     * 银行订单号
     */
    private String bankOrderNo;

    /**
     * 银行完成时间
     */
    private Date bankFinishTime;

    /**
     * 退款状态
     */
    private EnumRefundStatus refundStatus;

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
}