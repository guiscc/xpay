/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.impl;

import com.xpay.channel.common.dto.sms.SmsReqChannelDTO;
import com.xpay.channel.common.enums.EnumSMSMapKey;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.facade.SmsChannelFacade;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.customer.SignConfirmRepVO;
import com.xpay.payment.common.vo.customer.SignConfirmReqVO;
import com.xpay.payment.common.vo.customer.SignRepVO;
import com.xpay.payment.common.vo.customer.SignReqVO;
import com.xpay.payment.service.SmsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SmsServiceImpl.java, v 0.1 16/10/26 下午5:06 sxfans Exp $
 */
@Service
public class SmsServiceImpl implements SmsService {

    private static String code = "";

    @Resource
    private SmsChannelFacade smsChannelFacade;

    @Override
    public SignRepVO sendSignSms(SignReqVO signReqVO, SignRepVO signRepVO) throws XpayPaymentException {
        SmsReqChannelDTO smsReqDTO = new SmsReqChannelDTO();
        smsReqDTO.setUserId(signReqVO.getUserId());
        smsReqDTO.setTitle("注册验证");
        smsReqDTO.setContent("");
        String randomCode = RandomStringUtils.randomNumeric(6);
        signReqVO.setVerifyCode(randomCode);
        //TODO
        code = randomCode;
        smsReqDTO.setMobileNo(signReqVO.getMobileNo());
        smsReqDTO.setReqDateTime(new Date());
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.SMSCODE, signReqVO.getVerifyCode());
        smsReqDTO.getSmsExtMap().put(EnumSMSMapKey.TIME, "5");
        try {
            smsChannelFacade.sendSMS(smsReqDTO);
        } catch (XpayChannelException e) {
            throw new XpayPaymentException(EnumRtnResult.E000000);
        }
        return signRepVO;
    }

    @Override
    public SignConfirmRepVO confirmSignSms(SignConfirmReqVO smsReq, SignConfirmRepVO signConfirmRepVO) throws XpayPaymentException {
        if (!StringUtils.equals(code, smsReq.getVerifyCode())) {
            throw new XpayPaymentException(EnumRtnResult.E000000);
        }
        return signConfirmRepVO;
    }

}