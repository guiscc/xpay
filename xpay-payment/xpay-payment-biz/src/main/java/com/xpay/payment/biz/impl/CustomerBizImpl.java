/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.payment.biz.CustomerBiz;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import com.xpay.payment.common.vo.customer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author qinshou
 * @version $Id: CustomerBizImpl.java, v 0.1 16/8/7 上午1:06 sxfans Exp $
 */
@Component
public class CustomerBizImpl implements CustomerBiz {

    private static final Logger logger = LoggerFactory.getLogger(CustomerBizImpl.class);

    @Override
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO) {
        logger.info("暂未实现");
        return null;
    }

    @Override
    public SignRepVO sign(SignReqVO signRepVO) throws XpayPaymentException {
        
        return null;
    }

    @Override
    public SignConfirmRepVO signConfirm(SignConfirmReqVO signConfirmReqVO) throws XpayPaymentException {
        return null;
    }

    @Override
    public SignBreakRepVO signBreak(SignBreakReqVO signBreakReqVO) {
        return null;
    }
}