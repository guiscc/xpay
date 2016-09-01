/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.server.facade;

import com.xpay.payment.common.facade.AgentCollectFacade;
import com.xpay.payment.common.dto.agentcollect.AgentCollectRepDTO;
import com.xpay.payment.common.dto.agentcollect.AgentCollectReqDTO;
import com.xpay.payment.common.dto.agentcollect.QueryCollectRepDTO;
import com.xpay.payment.common.dto.agentcollect.QueryCollectReqDTO;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacadeImpl.java, v 0.1 16/8/6 下午9:27 sxfans Exp $
 */
public class AgentCollectFacadeImpl implements AgentCollectFacade {

    /**
     * 
     */
    private AgentCollectBiz agentCollectBiz;

    @Override
    public AgentCollectRepDTO pay(AgentCollectReqDTO agentCollectReqDTO) {
        
        return null;
    }


    @Override
    public QueryCollectRepDTO queryPay(QueryCollectReqDTO queryCollectReqDTO) {
        return null;
    }
}