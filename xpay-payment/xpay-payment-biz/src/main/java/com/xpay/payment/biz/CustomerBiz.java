/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz;

import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import com.xpay.payment.common.vo.agentcollect.BreakSignRepVO;
import com.xpay.payment.common.vo.agentcollect.BreakSignReqVO;
import com.xpay.payment.common.vo.agentcollect.SignRepVO;

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
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO);

    /**
     * 签约
     *
     * @param signRepVO
     * @return
     */
    public SignRepVO sign(SignRepVO signRepVO);

    /**
     * 解约
     *
     * @param breakSignReqVO
     * @return
     */
    public BreakSignRepVO breakSign(BreakSignReqVO breakSignReqVO);
}