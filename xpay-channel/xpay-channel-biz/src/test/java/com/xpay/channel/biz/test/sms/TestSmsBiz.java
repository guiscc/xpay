/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.test.sms;

import com.xpay.channel.biz.test.BaseTest;
import com.xpay.channel.common.dto.sms.SmsRepChannelDTO;
import com.xpay.channel.common.dto.sms.SmsReqChannelDTO;
import com.xpay.channel.common.enums.EnumSMSMapKey;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.facade.SmsChannelFacade;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestSmsBiz.java, v 0.1 16/10/26 下午4:23 sxfans Exp $
 */
public class TestSmsBiz extends BaseTest {

    @Resource
    private SmsChannelFacade smsChannelFacade;

    @Test
    public void testSms() throws XpayChannelException {
        SmsReqChannelDTO smsReqDTO = new SmsReqChannelDTO();
        smsReqDTO.setUserId("123456");
        smsReqDTO.setTitle("验证码");
        smsReqDTO.setContent("内容");
        smsReqDTO.setMobileNo("18317888059");
        smsReqDTO.setReqDateTime(new Date());
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.SMSCODE, "aaa");
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.TIME, "bbb");
        SmsRepChannelDTO smsRepChannelDTO = smsChannelFacade.sendSMS(smsReqDTO);
        System.out.println(smsRepChannelDTO);
    }
}