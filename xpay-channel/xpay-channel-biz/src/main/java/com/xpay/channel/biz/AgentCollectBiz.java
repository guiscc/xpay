/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz;

import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.vo.agentcollect.*;

/**
 * @author qinshou
 * @version $Id: AgentCollectBiz.java, v 0.1 16/10/15 上午10:08 sxfans Exp $
 */
public interface AgentCollectBiz {

    /**
     * 代付
     *
     * @param acPayReqVO
     * @return
     * @throws XpayChannelException
     */
    public ACPayRepVO pay(ACPayReqVO acPayReqVO) throws XpayChannelException;

    /**
     * 代收
     *
     * @param acQueryPayReqVO
     * @return
     * @throws XpayChannelException
     */
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayChannelException;

    /**
     * 补单
     *
     * @param acRepairReqVO
     * @return
     * @throws XpayChannelException
     */
    public ACRepairRepVO repair(ACRepairReqVO acRepairReqVO) throws XpayChannelException;

}