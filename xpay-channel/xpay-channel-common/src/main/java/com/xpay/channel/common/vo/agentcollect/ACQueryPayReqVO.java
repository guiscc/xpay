/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.vo.agentcollect;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACQueryPayReqVO.java, v 0.1 16/9/10 下午4:46 sxfans Exp $
 */
public class ACQueryPayReqVO {

    /**
     * 交易单号
     */
    private String tradeOrderNo;

    /**
     * 支付单号
     */
    private String payOrderNo;

    /**
     * 补单标志
     */
    private String repair;

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
     * Getter method for property repair.
     *
     * @return property value of repair
     **/
    public String getRepair() {
        return repair;
    }

    /**
     * Setter method for property repair.
     *
     * @param repair value to be assigned to property repair
     **/
    public void setRepair(String repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}