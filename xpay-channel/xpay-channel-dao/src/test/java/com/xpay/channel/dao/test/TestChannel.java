/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.test;

import com.xpay.channel.dao.ChannelDao;
import com.xpay.channel.dao.entity.ChannelEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qinshou
 * @version $Id: TestChannel.java, v 0.1 16/12/6 上午12:08 sxfans Exp $
 */
public class TestChannel extends BaseTest {

    @Resource
    private ChannelDao channelDao;

    @Test
    public  void findChannels(){
        String channelCodes = "\"AC_YEEPAY_CD_01\",\"AC_ALIPAY_CD_01\",\"AC_YEEPAY_CD_01\"";
        List<ChannelEntity> list = channelDao.findByChannelCode(channelCodes);
        System.out.println(list);
    }

    @Test
    public void get(){
        String channelCodes = "AC_YEEPAY_CD_01";
        ChannelEntity channelEntity = channelDao.get(channelCodes);
        System.out.println(channelEntity);
    }
}