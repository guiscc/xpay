/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service;

import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.customer.SignConfirmRepVO;
import com.xpay.payment.common.vo.customer.SignConfirmReqVO;
import com.xpay.payment.common.vo.customer.SignRepVO;
import com.xpay.payment.common.vo.customer.SignReqVO;

/**
 * @author qinshou
 * @version $Id: SmsServiceImpl.java, v 0.1 16/10/26 下午5:05 sxfans Exp $
 */
public interface SmsService {

    /**
     * 发送确认短信 对应有时间确认的验证码
     * @param smsReq
     * @param signRepVO
     * @return
     * @throws XpayChannelException
     */
    public SignRepVO sendSignSms(SignReqVO smsReq, SignRepVO signRepVO) throws XpayPaymentException;

    /**
     * 短信确认
     * @param smsReq
     * @param signConfirmRepVO
     * @return
     * @throws XpayChannelException
     */
    public SignConfirmRepVO confirmSignSms(SignConfirmReqVO smsReq, SignConfirmRepVO signConfirmRepVO) throws XpayPaymentException;
}