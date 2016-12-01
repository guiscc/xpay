/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.test;

import com.xpay.channel.dao.PayInfoDao;
import com.xpay.channel.dao.entity.PayInfoEntity;
import com.xpay.common.enums.EnumCurrency;
import com.xpay.common.enums.EnumPayStatus;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.utils.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestPayInfo.java, v 0.1 16/11/30 下午2:09 sxfans Exp $
 */
public class TestPayInfo extends BaseTest {

    @Resource
    private PayInfoDao payInfoDao;

    @Test
    public void getPayInfo() {
        PayInfoEntity payInfoEntity = payInfoDao.findByPayOrderNo("20161201144552706");
        System.out.println(payInfoEntity);
    }

    @Test
    public void addPayInfo() {
        PayInfoEntity payInfoEntity = new PayInfoEntity();
        String payOrderNo = DateUtil.DateStampToStringNoSp(new Date());
        payInfoEntity.setPayOrderNo(payOrderNo);
        payInfoEntity.setBankOrderNo("PAY"+payOrderNo);
        payInfoEntity.setPayAmt(new BigDecimal(1.99));
        payInfoEntity.setCurrency(EnumCurrency.CNY.getKey());
        payInfoEntity.setChannelCode("AC_UNION_CD_01");
        payInfoEntity.setPayToolsBankCode("AC_ABC_C");

        payInfoEntity.setCreateDT(new Date());
        payInfoEntity.setMerchantNo("600788881");
        payInfoEntity.setPayStatus(EnumPayStatus.SUCCESS.getKey());
        payInfoEntity.setPaySubToolCode(EnumPaySubTool.QUICKPAY.getKey());

        int i = payInfoDao.add(payInfoEntity);
        System.out.println("###########"+i);
    }
}