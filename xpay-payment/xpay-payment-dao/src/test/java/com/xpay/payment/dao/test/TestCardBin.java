/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.dao.test;

import com.xpay.payment.dao.CardBinDao;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestCardBin.java, v 0.1 16/12/12 上午9:47 sxfans Exp $
 */
public class TestCardBin extends BaseTest {

    @Resource
    private CardBinDao cardBinDao;

    @Test
    public void getCardBin(){
        System.out.println("*************"+cardBinDao);
        System.out.println(cardBinDao.getCardBin("6217730703774214"));
    }
}