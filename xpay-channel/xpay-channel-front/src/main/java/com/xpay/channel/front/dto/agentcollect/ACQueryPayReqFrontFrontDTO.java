/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseReqFrontDTO;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: ACQueryPayReqFrontFrontDTO.java, v 0.1 16/10/17 下午2:03 sxfans Exp $
 */
public class ACQueryPayReqFrontFrontDTO extends BaseReqFrontDTO {

    /**
     * 银行订单号
     */
    private String bankOrderNo;

    /**
     * 银行流水
     */
    private String bankNo;

    /**
     * 支付订单号
     */
    private Date payOrderDT;

    /**
     * Getter method for property bankOrderNo.
     *
     * @return property value of bankOrderNo
     **/
    public String getBankOrderNo() {
        return bankOrderNo;
    }

    /**
     * Getter method for property payOrderDT.
     *
     * @return property value of payOrderDT
     **/
    public Date getPayOrderDT() {
        return payOrderDT;
    }

    /**
     * Setter method for property payOrderDT.
     *
     * @param payOrderDT value to be assigned to property payOrderDT
     **/
    public void setPayOrderDT(Date payOrderDT) {
        this.payOrderDT = payOrderDT;
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