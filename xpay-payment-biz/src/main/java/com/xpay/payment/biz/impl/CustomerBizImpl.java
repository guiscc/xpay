/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.payment.biz.CustomerBiz;
import com.xpay.trade.common.vo.AuthRealNameRepVO;
import com.xpay.trade.common.vo.AuthRealNameReqVO;
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
}