/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test;

import com.xpay.payment.biz.AgentCollectBiz;
import com.xpay.payment.common.dto.agentcollect.ACQueryPayReqDTO;
import com.xpay.payment.common.dto.agentpay.QueryPayReqDTO;
import com.xpay.payment.common.facade.AgentCollectFacade;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestQueryPay.java, v 0.1 16/9/15 下午6:17 sxfans Exp $
 */
public class TestQueryPay extends BaseTest {
    /**
     *
     */
    @Resource
    private AgentCollectFacade agentCollectFacade;

    @Test
    public void queryPayByTradeOrderNo(){
        ACQueryPayReqDTO queryPayReqDTO = new ACQueryPayReqDTO();
        queryPayReqDTO.setTradeOrderNo("123");
        agentCollectFacade.queryPay(queryPayReqDTO);
    }

    @Test
    public void queryPayByPayOrderNo(){
        ACQueryPayReqDTO queryPayReqDTO = new ACQueryPayReqDTO();
        queryPayReqDTO.setPayOrderNo("321");
        agentCollectFacade.queryPay(queryPayReqDTO);
    }
}