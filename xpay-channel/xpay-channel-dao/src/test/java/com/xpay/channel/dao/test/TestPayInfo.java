/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.test;

import com.xpay.channel.dao.PayInfoDao;
import com.xpay.channel.dao.entity.PayInfoEntity;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestPayInfo.java, v 0.1 16/11/30 下午2:09 sxfans Exp $
 */
public class TestPayInfo extends BaseTest {

    @Resource
    private PayInfoDao payInfoDao;

    @Test
    public void getPayInfo() {
        PayInfoEntity payInfoEntity = payInfoDao.findByPayOrderNo("123456");
        System.out.println(payInfoEntity);
    }
}