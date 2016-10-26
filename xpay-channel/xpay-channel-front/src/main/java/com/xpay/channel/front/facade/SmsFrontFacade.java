/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.facade;

import com.xpay.channel.common.exception.FrontException;
import com.xpay.channel.front.dto.sms.SmsRepFrontDTO;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;

/**
 * @author qinshou
 * @version $Id: SmsFrontFacadeImpl.java, v 0.1 16/10/24 下午5:05 sxfans Exp $
 */
public interface SmsFrontFacade {

    /**
     * 发短信
     * @param smsReqDTO
     * @return
     */
    public SmsRepFrontDTO sendSMS(SmsReqFrontDTO smsReqDTO) throws FrontException;
}