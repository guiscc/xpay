/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.facade;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthRepDTO;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqDTO;

/**
 * @author qinshou
 * @version $Id: CustomerChannelFacade.java, v 0.1 16/10/17 上午11:42 sxfans Exp $
 */
public interface CustomerChannelFacade {

    /**
     * 实名认证
     * @param reqDto
     * @return
     * @throws VldException
     * @throws BuildMsgException
     * @throws CommuException
     * @throws ResolveMsgException
     */
    public RealNameAuthRepDTO auth(RealNameAuthReqDTO reqDto) throws VldException,
                                                             BuildMsgException, CommuException,
                                                             ResolveMsgException;
}