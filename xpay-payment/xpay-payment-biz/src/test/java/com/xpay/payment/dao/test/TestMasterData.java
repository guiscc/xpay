/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.dao.test;

import com.xpay.payment.biz.MasterDataBiz;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestMasterData.java, v 0.1 16/12/12 下午2:09 sxfans Exp $
 */
public class TestMasterData extends BaseTest {

    @Resource
    MasterDataBiz masterDataBiz;

    @Test
    public void getCardBin(){
        System.out.println(masterDataBiz);
    }
}