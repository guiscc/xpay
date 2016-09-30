/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.facade;

import com.xpay.payment.common.dto.customer.*;

/**
 * 用户接口
 *
 * @author qinshou
 * @version $Id: UserFacade.java, v 0.1 16/8/6 下午10:11 sxfans Exp $
 */
public interface CustomerFacade {

    /**
     * 实名认证
     *
     * @param customerReqDTO
     * @return
     */
    public AuthRealNameRepDTO authRealName(AuthRealNameReqDTO customerReqDTO);

    /**
     * 签约绑卡
     *
     * @param signReqDTO
     * @return
     */
    public SignRepDTO sign(SignReqDTO signReqDTO);

    /**
     * 签约确认
     *
     * @param confirmSignReqDTO
     * @return
     */
    public ConfirmSignRepDTO confirmSign(ConfirmSignReqDTO confirmSignReqDTO);

    /**
     * 解约
     *
     * @param breakSignReqDTO
     * @return
     */
    public BreakSignRepDTO breakSign(BreakSignReqDTO breakSignReqDTO);
}