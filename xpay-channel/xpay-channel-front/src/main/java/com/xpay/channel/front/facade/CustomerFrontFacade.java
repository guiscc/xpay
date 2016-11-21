/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.facade;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqFrontDTO;

/**
 * @author qinshou
 * @version $Id: CustomerFrontFacade.java, v 0.1 16/10/17 上午11:42 sxfans Exp $
 */
public interface CustomerFrontFacade {

    /**
     * 实名认证
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RealNameAuthRepFrontDTO auth(RealNameAuthReqFrontDTO reqDto);
}