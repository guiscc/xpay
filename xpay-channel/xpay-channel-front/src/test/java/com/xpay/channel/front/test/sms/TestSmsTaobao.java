/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.sms;

import com.xpay.channel.common.enums.EnumSMSMapKey;
import com.xpay.channel.common.exception.*;
import com.xpay.channel.front.dto.sms.SmsRepFrontDTO;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.facade.SmsFrontFacade;
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
    private SmsFrontFacade smsFrontFacade;

    @Test
    public void sendSms() throws FrontException {
        SmsReqFrontDTO smsReqDTO = new SmsReqFrontDTO();
        smsReqDTO.setUserId("123456");
        smsReqDTO.setTitle("注册验证aa");
        smsReqDTO.setContent("内容");
        smsReqDTO.setMobileNo("18317888059");
        smsReqDTO.setReqDateTime(new Date());
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.SMSCODE, "aaa");
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.SMS_PRODUCT_NAME, "bbb");
        smsReqDTO.setChannelCode("SMS_TAOBAO");
        SmsRepFrontDTO smsRepDTO = smsFrontFacade.sendSMS(smsReqDTO);
        System.out.println(smsRepDTO);
    }
}