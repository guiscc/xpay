/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.payment.biz.CustomerBiz;
import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import com.xpay.payment.common.vo.agentcollect.BreakSignRepVO;
import com.xpay.payment.common.vo.agentcollect.BreakSignReqVO;
import com.xpay.payment.common.vo.agentcollect.SignRepVO;
import org.springframework.stereotype.Component;

/**
 * @author qinshou
 * @version $Id: CustomerBizImpl.java, v 0.1 16/8/7 上午1:06 sxfans Exp $
 */
@Component
public class CustomerBizImpl implements CustomerBiz {


    @Override
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO) {
        return null;
    }

    @Override
    public SignRepVO sign(SignRepVO signRepVO) {
        return null;
    }

    @Override
    public BreakSignRepVO breakSign(BreakSignReqVO breakSignReqVO) {
        return null;
    }
}