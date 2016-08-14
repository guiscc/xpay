package com.xpay.trade.common.facade;

import com.xpay.trade.common.dto.agentpay.AgentPayRepDTO;
import com.xpay.trade.common.dto.agentpay.AgentPayReqDTO;
import com.xpay.trade.common.dto.agentpay.QueryPayReqDTO;
import com.xpay.trade.common.dto.agentpay.QueryPayRepDTO;

/**
 * 代付接口
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