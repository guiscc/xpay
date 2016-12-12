/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.facade;

import com.xpay.channel.biz.SmsChannelBiz;
import com.xpay.channel.biz.convert.SmsConvert;
import com.xpay.channel.common.dto.sms.SmsRepChannelDTO;
import com.xpay.channel.common.dto.sms.SmsReqChannelDTO;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.facade.SmsChannelFacade;
import com.xpay.channel.common.vo.sms.SmsRepVO;
import com.xpay.channel.common.vo.sms.SmsReqVO;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: SmsChannelFacadeImpl.java, v 0.1 16/10/26 上午11:03 sxfans Exp $
 */
public class SmsChannelFacadeImpl implements SmsChannelFacade {

    @Resource(name = "smsChannelBiz")
    private SmsChannelBiz smsChannelBiz;

    @Override
    public SmsRepChannelDTO sendSMS(SmsReqChannelDTO smsReq) throws XpayChannelException {
        SmsReqVO smsReqVO = SmsConvert.getSmsReqVO(new SmsReqVO(), smsReq);
        SmsRepVO smsRepVO = smsChannelBiz.sendSMS(smsReqVO);
        SmsRepChannelDTO smsRepChannelDTO = SmsConvert.getSmsRepDTO(new SmsRepChannelDTO(), smsRepVO);
        return smsRepChannelDTO;
    }
}