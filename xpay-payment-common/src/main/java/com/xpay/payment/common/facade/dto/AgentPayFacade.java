package com.xpay.payment.common.facade.dto;

import com.xpay.payment.common.facade.dto.agentpay.AgentPayRepDTO;
import com.xpay.payment.common.facade.dto.agentpay.AgentPayReqDTO;
import com.xpay.payment.common.facade.dto.agentpay.QueryPayRepDTO;
import com.xpay.payment.common.facade.dto.agentpay.QueryPayReqDTO;

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