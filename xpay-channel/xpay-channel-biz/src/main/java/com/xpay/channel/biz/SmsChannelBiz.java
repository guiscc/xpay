/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz;

import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.vo.sms.SmsRepVO;
import com.xpay.channel.common.vo.sms.SmsReqVO;

/**
 * @author qinshou
 * @version $Id: SmsChannelBiz.java, v 0.1 16/10/26 上午11:27 sxfans Exp $
 */
public interface SmsChannelBiz {

    /**
     * 发送短信
     * @param smsReqVO
     * @return
     */
    public SmsRepVO sendSMS(SmsReqVO smsReqVO) throws XpayChannelException;
}