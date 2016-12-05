/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.test;

import com.xpay.channel.dao.MerchantMappingDao;
import com.xpay.channel.dao.entity.MerchantMappingEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qinshou
 * @version $Id: TestMerchantMapping.java, v 0.1 16/12/5 下午2:41 sxfans Exp $
 */
public class TestMerchantMapping extends BaseTest {

    @Resource
    private MerchantMappingDao merchantMappingDao;

    @Test
    public void merchantMapping() {
        String codes = "\"ALIPAY\",\"UNIONPAY\"";
        List<MerchantMappingEntity> list = merchantMappingDao.findByInstCode(codes);
        System.out.println(list);
    }
}