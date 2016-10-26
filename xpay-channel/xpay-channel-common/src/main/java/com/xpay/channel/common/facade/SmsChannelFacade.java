/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.facade;

import com.xpay.channel.common.dto.sms.SmsRepChannelDTO;
import com.xpay.channel.common.dto.sms.SmsReqChannelDTO;
import com.xpay.channel.common.exception.XpayChannelException;

/**
 * @author qinshou
 * @version $Id: SmsChannelFacade.java, v 0.1 16/10/26 上午11:03 sxfans Exp $
 */
public interface SmsChannelFacade {

    /**
     * 发送短信
     * @param smsReq
     * @return
     */
    public SmsRepChannelDTO sendSMS(SmsReqChannelDTO smsReq) throws XpayChannelException;
}