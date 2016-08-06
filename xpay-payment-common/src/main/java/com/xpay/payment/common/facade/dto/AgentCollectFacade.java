/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.facade.dto;

import com.xpay.payment.common.facade.dto.agentcollect.AgentCollectRepDTO;
import com.xpay.payment.common.facade.dto.agentcollect.AgentCollectReqDTO;
import com.xpay.payment.common.facade.dto.agentcollect.QueryCollectRepDTO;
import com.xpay.payment.common.facade.dto.agentcollect.QueryCollectReqDTO;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacade.java, v 0.1 16/7/31 上午11:06 sxfans Exp $
 */
public interface AgentCollectFacade {

    /**
     * 代收
     * @param agentCollectReqDTO
     * @return
     */
    public AgentCollectRepDTO pay(AgentCollectReqDTO agentCollectReqDTO);

    /**
     * 查询代收
     * @param queryCollectReqDTO
     * @return
     */
    public QueryCollectRepDTO queryPay(QueryCollectReqDTO queryCollectReqDTO);
}