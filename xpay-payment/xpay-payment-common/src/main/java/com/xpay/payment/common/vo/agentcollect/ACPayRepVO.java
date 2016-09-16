/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.agentcollect;

import com.xpay.payment.common.model.PayOrderModel;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACPayReqVO.java, v 0.1 16/8/7 下午10:57 sxfans Exp $
 */
public class ACPayRepVO {

    /**
     * 支付订单模型
     */
    private PayOrderModel payOrderModel;

    /**
     * Getter method for property payOrderModel.
     *
     * @return property value of payOrderModel
     **/
    public PayOrderModel getPayOrderModel() {
        return payOrderModel;
    }

    /**
     * Setter method for property payOrderModel.
     *
     * @param payOrderModel value to be assigned to property payOrderModel
     **/
    public void setPayOrderModel(PayOrderModel payOrderModel) {
        this.payOrderModel = payOrderModel;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}