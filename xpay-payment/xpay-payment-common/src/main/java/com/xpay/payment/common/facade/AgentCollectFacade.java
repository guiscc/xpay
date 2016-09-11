/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.facade;

import com.xpay.payment.common.dto.agentcollect.ACPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACPayReqDTO;
import com.xpay.payment.common.dto.agentcollect.ACQueryPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACQueryPayReqDTO;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacade.java, v 0.1 16/7/31 上午11:06 sxfans Exp $
 */
public interface AgentCollectFacade {

    /**
     * 代收
     *
     * @param ACPayReqDTO
     * @return
     */
    public ACPayRepDTO pay(ACPayReqDTO ACPayReqDTO);

    /**
     * 查询代收
     *
     * @param ACQueryPayReqDTO
     * @return
     */
    public ACQueryPayRepDTO queryPay(ACQueryPayReqDTO ACQueryPayReqDTO);
}