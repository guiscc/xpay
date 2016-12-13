/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.test;

import com.xpay.payment.service.OrderNoService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestPaymentOrder.java, v 0.1 16/12/9 上午10:20 sxfans Exp $
 */
public class TestPaymentOrder extends BaseTest {
    @Resource
    private OrderNoService orderNoService;

    @Test
    public void testSign() {
        String orderNo = orderNoService.getOrderNo();
        System.out.println(orderNo);
    }
}