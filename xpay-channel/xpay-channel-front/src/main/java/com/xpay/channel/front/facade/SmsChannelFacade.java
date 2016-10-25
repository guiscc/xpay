/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.facade;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.sms.SmsRep;
import com.xpay.channel.front.dto.sms.SmsReq;

/**
 * @author qinshou
 * @version $Id: SmsChannelFacadeImpl.java, v 0.1 16/10/24 下午5:05 sxfans Exp $
 */
public interface SmsChannelFacade {

    /**
     * 发短信
     * @param smsReq
     * @return
     */
    public SmsRep sendSMS(SmsReq smsReq) throws BuildMsgException, ResolveMsgException, VldException, CommuException;
}