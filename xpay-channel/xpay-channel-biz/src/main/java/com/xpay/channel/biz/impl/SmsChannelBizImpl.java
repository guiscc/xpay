/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.impl;

import com.xpay.channel.biz.SmsChannelBiz;
import com.xpay.channel.common.enums.EnumExtMapKey;
import com.xpay.channel.common.exception.FrontException;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.vo.sms.SmsRepVO;
import com.xpay.channel.common.vo.sms.SmsReqVO;
import com.xpay.channel.front.dto.sms.SmsRepFrontDTO;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.facade.SmsFrontFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SmsChannelBizImpl.java, v 0.1 16/10/26 上午11:29 sxfans Exp $
 */
@Component
public class SmsChannelBizImpl implements SmsChannelBiz {

    @Resource
    private SmsFrontFacade smsFrontFacade;

    @Override
    public SmsRepVO sendSMS(SmsReqVO smsReqVO) throws XpayChannelException {
        try {
            SmsReqFrontDTO smsReqFrontDTO = new SmsReqFrontDTO();

            smsReqFrontDTO.setUserId(smsReqVO.getUserId());
            smsReqFrontDTO.setTitle(smsReqVO.getTitle()); //必填
            smsReqFrontDTO.setContent(smsReqVO.getContent());
            smsReqFrontDTO.setMobileNo(smsReqVO.getMobileNo()); //必填
            smsReqFrontDTO.setReqDateTime(new Date());
            smsReqFrontDTO.setExtMap(smsReqVO.getExtMap());
            smsReqFrontDTO.setChannelCode("SMS_TAOBAO");
            SmsRepFrontDTO smsRepDTO = smsFrontFacade.sendSMS(smsReqFrontDTO);
            SmsRepVO smsRepVO = new SmsRepVO();
            smsRepVO.setSmsStatus(smsRepDTO.getSmsStatus());
            return smsRepVO;
        } catch (FrontException e) {
            throw new XpayChannelException(e.getRtnResult());
        }
    }
}