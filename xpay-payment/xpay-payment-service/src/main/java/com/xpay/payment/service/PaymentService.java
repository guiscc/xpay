/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service;

import com.xpay.payment.common.model.PayOrderModel;

/**
 * @author qinshou
 * @version $Id: PaymentService.java, v 0.1 16/8/29 下午1:24 sxfans Exp $
 */
public interface PaymentService {

    /**
     * 新增支付单
     * @param payOrderModel
     * @return
     */
    public PayOrderModel add(PayOrderModel payOrderModel);

    /**
     *
     * @param payOrderModel
     * @return
     */
    public boolean update(PayOrderModel payOrderModel);

    /**
     * 交易单号查询
     * @param tradeOrderNo
     * @return
     */
    public PayOrderModel getByTradeOrderNo(String tradeOrderNo);

    /**
     * 支付单号查询
     * @param payOrderNo
     * @return
     */
    public PayOrderModel getByPayOrderNo(String payOrderNo);
}