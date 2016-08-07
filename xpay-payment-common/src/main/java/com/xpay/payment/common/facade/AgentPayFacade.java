package com.xpay.payment.common.facade;

import com.xpay.payment.common.dto.agentpay.AgentPayRepDTO;
import com.xpay.payment.common.dto.agentpay.AgentPayReqDTO;
import com.xpay.payment.common.dto.agentpay.QueryPayReqDTO;
import com.xpay.payment.common.dto.agentpay.QueryPayRepDTO;

/**
 * @author qinshou
 * @version $Id: AgentPayFacade.java, v 0.1 16/7/31 上午12:07 sxfans Exp $
 */
public interface AgentPayFacade {

    /**
     * 
     * @param agentPayReqDTO
     * @return
     */
    public AgentPayRepDTO pay(AgentPayReqDTO agentPayReqDTO);

    /**
     * 查询代付
     * @param queryPayReqDTO
     * @return
     */
    public QueryPayRepDTO queryPay(QueryPayReqDTO queryPayReqDTO);
}