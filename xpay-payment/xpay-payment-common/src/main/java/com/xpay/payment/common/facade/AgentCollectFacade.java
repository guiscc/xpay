/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.facade;

import com.xpay.payment.common.dto.agentcollect.*;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacade.java, v 0.1 16/7/31 上午11:06 sxfans Exp $
 */
public interface AgentCollectFacade {

    /**
     * 代收
     *
     * @param acPayReqDTO
     * @return
     */
    public ACPayRepDTO pay(ACPayReqDTO acPayReqDTO);

    /**
     * 查询代收
     *
     * @param acQueryPayReqDTO
     * @return
     */
    public ACQueryPayRepDTO queryPay(ACQueryPayReqDTO acQueryPayReqDTO);

    /**
     * 补单
     *
     * @param acRepairReqDTO
     * @return
     */
    public ACRepairRepDTO repair(ACRepairReqDTO acRepairReqDTO);
}