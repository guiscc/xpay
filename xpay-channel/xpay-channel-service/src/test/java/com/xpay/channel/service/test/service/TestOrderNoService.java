/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.test.service;

import com.xpay.channel.service.order.OrderNoService;
import com.xpay.channel.service.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestOrderNoService.java, v 0.1 16/12/8 下午2:30 sxfans Exp $
 */
public class TestOrderNoService extends BaseTest {

    @Resource
    private OrderNoService orderNoService;

    @Test
    public void test(){
        System.out.println(orderNoService.getOrderNo());
    }
}