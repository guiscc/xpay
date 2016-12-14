package com.xpay.channel.facade.test;

import com.xpay.channel.common.dto.sms.SmsRepChannelDTO;
import com.xpay.channel.common.dto.sms.SmsReqChannelDTO;
import com.xpay.channel.common.enums.EnumSMSMapKey;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.facade.SmsChannelFacade;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by hui on 2016/12/13.
 */
public class TestSmsFacade extends BaseTest {

    @Resource
    private SmsChannelFacade smsChannelFacade;

    @Test
    public void testSms() throws XpayChannelException {
        SmsReqChannelDTO smsReqDTO = new SmsReqChannelDTO();
        smsReqDTO.setUserId("123456");
        smsReqDTO.setTitle("注册验证");
        smsReqDTO.setContent("内容");
        smsReqDTO.setMobileNo("13393705178");
        smsReqDTO.setReqDateTime(new Date());
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.SMSCODE, "aaa");
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.TIME, "bbb");
        SmsRepChannelDTO smsRepChannelDTO = smsChannelFacade.sendSMS(smsReqDTO);
        System.out.println(smsRepChannelDTO);
    }
}
