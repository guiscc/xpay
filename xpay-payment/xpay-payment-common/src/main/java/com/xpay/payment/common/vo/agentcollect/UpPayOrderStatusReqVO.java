/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.agentcollect;

import com.xpay.common.enums.EnumPayStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: UpPayOrderStatusReqVO.java, v 0.1 16/8/31 下午1:49 sxfans Exp $
 */
public class UpPayOrderStatusReqVO {

    /**
     * 支付状态
     */
    private EnumPayStatus payOrderStatus;

    /**
     * 交易单号
     */
    private String tradeOrderNo;

    /**
     * Getter method for property payOrderStatus.
     *
     * @return property value of payOrderStatus
     **/
    public EnumPayStatus getPayOrderStatus() {
        return payOrderStatus;
    }

    /**
     * Setter method for property payOrderStatus.
     *
     * @param payOrderStatus value to be assigned to property payOrderStatus
     **/
    public void setPayOrderStatus(EnumPayStatus payOrderStatus) {
        this.payOrderStatus = payOrderStatus;
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
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}