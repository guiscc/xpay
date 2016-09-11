/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz;

import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import com.xpay.payment.common.vo.customer.*;

/**
 * @author qinshou
 * @version $Id: CustomerBiz.java, v 0.1 16/8/7 上午1:06 sxfans Exp $
 */
public interface CustomerBiz {

    /**
     * 实名认证
     *
     * @param authRealNameReqDTO
     * @return
     */
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO) throws XpayPaymentException;

    /**
     * 签约
     *
     * @param signRepVO
     * @return
     */
    public SignRepVO sign(SignReqVO signRepVO) throws XpayPaymentException;

    /**
     * 签约绑卡确认
     *
     * @param signConfirmReqVO
     * @return
     */
    public SignConfirmRepVO signConfirm(SignConfirmReqVO signConfirmReqVO) throws XpayPaymentException;

    /**
     * 解约
     *
     * @param signBreakReqVO
     * @return
     */
    public SignBreakRepVO signBreak(SignBreakReqVO signBreakReqVO) throws XpayPaymentException;
}