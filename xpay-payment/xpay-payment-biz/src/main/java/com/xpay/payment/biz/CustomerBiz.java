/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz;

import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;

/**
 * @author qinshou
 * @version $Id: CustomerBiz.java, v 0.1 16/8/7 上午1:06 sxfans Exp $
 */
public interface CustomerBiz {

    /**
     * 实名认证
     * @param authRealNameReqDTO
     * @return
     */
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO);
}