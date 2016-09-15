/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test;

import com.xpay.payment.common.dto.agentcollect.ACPayReqDTO;
import com.xpay.payment.common.facade.AgentCollectFacade;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestPayment.java, v 0.1 16/9/15 下午3:44 sxfans Exp $
 */
public class TestPayment extends BaseTest {

    /**
     * 代收
     */
    @Resource
    private AgentCollectFacade collectFacade;

    @Test
    public void payment() {
        ACPayReqDTO acRepairReqDTO = new ACPayReqDTO();
        acRepairReqDTO.setTradeOrderNo("");
        collectFacade.pay(acRepairReqDTO);
    }
}