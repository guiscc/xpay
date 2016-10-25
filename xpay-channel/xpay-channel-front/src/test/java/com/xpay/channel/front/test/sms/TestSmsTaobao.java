/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.sms;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.sms.SmsRep;
import com.xpay.channel.front.dto.sms.SmsReq;
import com.xpay.channel.front.facade.SmsChannelFacade;
import com.xpay.channel.front.factory.SmsChannelMappingFactory;
import com.xpay.channel.front.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestSmsTaobao.java, v 0.1 16/10/25 上午1:24 sxfans Exp $
 */
public class TestSmsTaobao extends BaseTest {

    @Resource
    private SmsChannelMappingFactory smsChannelMappingFactory;

    @Test
    public void sendSms() throws VldException, BuildMsgException, CommuException,
                         ResolveMsgException {
        SmsChannelFacade smsChannelFacade = smsChannelMappingFactory.getChannelBean("SMS_TAOBAO");
        SmsReq smsReq = new SmsReq();
        smsReq.setTitle("注册验证");
        smsReq.setContent("内容");
        smsReq.setMobileNo("18317888059");
        smsReq.setReqDateTime(new Date());
        SmsRep smsRep = smsChannelFacade.sendSMS(smsReq);
        System.out.println(smsRep);
    }
}