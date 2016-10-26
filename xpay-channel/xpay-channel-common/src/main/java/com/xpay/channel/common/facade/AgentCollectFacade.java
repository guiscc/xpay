/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.facade;

import com.xpay.channel.common.dto.agentcollect.*;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacade.java, v 0.1 16/10/5 下午10:28 sxfans Exp $
 */
public interface AgentCollectFacade {

    /**
     * 代收
     *
     * @param acPayReqDTO
     * @return
     */
    public ACPayRepChannelDTO pay(ACPayReqChannelDTO acPayReqDTO);

    /**
     * 查询代收
     *
     * @param acQueryPayReqDTO
     * @return
     */
    public ACQueryPayRepChannelDTO queryPay(ACQueryPayReqChannelDTO acQueryPayReqDTO);

    /**
     * 补单
     *
     * @param acRepairReqDTO
     * @return
     */
    public ACRepairRepChannelDTO repair(ACRepairReqChannelDTO acRepairReqDTO);
}