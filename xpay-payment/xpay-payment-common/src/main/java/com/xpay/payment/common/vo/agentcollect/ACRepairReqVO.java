/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.agentcollect;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACRepairReqVO.java, v 0.1 16/9/14 上午11:50 sxfans Exp $
 */
public class ACRepairReqVO {

    /**
     * 交易号
     */
    private String tradeOrderNo;

    /**
     * 签约号
     */
    private String payOrderNo;

    /**
     * 补单来源
     */
    private String repairSource;

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
     * Getter method for property repairSource.
     *
     * @return property value of repairSource
     **/
    public String getRepairSource() {
        return repairSource;
    }

    /**
     * Setter method for property repairSource.
     *
     * @param repairSource value to be assigned to property repairSource
     **/
    public void setRepairSource(String repairSource) {
        this.repairSource = repairSource;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}