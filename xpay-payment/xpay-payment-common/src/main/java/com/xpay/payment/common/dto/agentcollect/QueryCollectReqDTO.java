/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.agentcollect;

import com.xpay.payment.common.dto.BaseReqDTO;

/**
 * @author qinshou
 * @version $Id: QueryCollectReqDTO.java, v 0.1 16/7/31 上午11:10 sxfans Exp $
 */
public class QueryCollectReqDTO extends BaseReqDTO{

    /**
     * 交易订单号
     */
    private String tradeOrderNo;

    /**
     * 支付订单号
     */
    private String payOrderNo;



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
}