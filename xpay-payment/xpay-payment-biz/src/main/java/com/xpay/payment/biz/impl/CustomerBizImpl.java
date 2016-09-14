/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.payment.biz.CustomerBiz;
import com.xpay.payment.common.enums.EnumSignStatus;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import com.xpay.payment.common.vo.customer.*;
import com.xpay.payment.service.SignService;
import com.xpay.trade.common.exception.XpayTradeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: CustomerBizImpl.java, v 0.1 16/8/7 上午1:06 sxfans Exp $
 */
@Component
public class CustomerBizImpl implements CustomerBiz {

    private static final Logger logger = LoggerFactory.getLogger(CustomerBizImpl.class);

    @Resource
    private SignService signService;

    @Override
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO) {
        logger.info("暂未实现");
        return null;
    }

    @Override
    public SignRepVO sign(SignReqVO signReqVO) throws XpayPaymentException {
        SignRepVO signRepVO = signService.add(signReqVO);
        if(signRepVO == null){
            throw new XpayPaymentException();
        }
        return signRepVO;
    }

    @Override
    public SignConfirmRepVO signConfirm(SignConfirmReqVO signConfirmReqVO) throws XpayPaymentException {
        SignConfirmRepVO signConfirmRepVO = signService.signConfirm(signConfirmReqVO);
        if(signConfirmRepVO == null){
            throw new XpayPaymentException();
        }
        return signConfirmRepVO;
    }

    @Override
    public SignBreakRepVO signBreak(SignBreakReqVO signBreakReqVO) throws XpayPaymentException {
        SignBreakRepVO signBreakRepVO = signService.signBreak(signBreakReqVO);
        if(signBreakRepVO == null){
            throw new XpayPaymentException();
        }
        return signBreakRepVO;
    }
}