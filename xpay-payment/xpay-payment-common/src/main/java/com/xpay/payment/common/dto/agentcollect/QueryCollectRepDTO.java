/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.agentcollect;

import java.math.BigDecimal;

/**
 * @author qinshou
 * @version $Id: QueryCollectRepDTO.java, v 0.1 16/7/31 上午11:10 sxfans Exp $
 */
public class QueryCollectRepDTO {

    /**
     * 主键
     */
    private String id;

    /**
     * 交易号
     */
    private String tradeOrderNo;

    /**
     * 支付单号
     */
    private String payOrderNo;

    /**
     * 支付金额
     */
    private BigDecimal payAmt;

    /**
     * Getter method for property id.
     *
     * @return property value of id
     **/
    public String getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     **/
    public void setId(String id) {
        this.id = id;
    }

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
}