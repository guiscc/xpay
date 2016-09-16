/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test;

import com.xpay.payment.common.dto.agentcollect.ACRepairRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACRepairReqDTO;
import com.xpay.payment.common.facade.AgentCollectFacade;
import com.xpay.payment.common.vo.agentcollect.ACRepairRepVO;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestRepair.java, v 0.1 16/9/15 下午6:18 sxfans Exp $
 */
public class TestRepair extends BaseTest {

    @Resource
    private AgentCollectFacade agentCollectFacade;

    @Test
    public void repairByTradeOrderNo() {
        ACRepairReqDTO acRepairReqDTO = new ACRepairReqDTO();
        acRepairReqDTO.setTradeOrderNo("13");
        ACRepairRepDTO acRepairRepDTO = agentCollectFacade.repair(acRepairReqDTO);
        System.out.println("######"+acRepairRepDTO);
    }

    @Test
    public void repairPaymentOrderNo() {
        ACRepairReqDTO acRepairReqDTO = new ACRepairReqDTO();
        acRepairReqDTO.setPayOrderNo("12");
        ACRepairRepDTO acRepairRepDTO = agentCollectFacade.repair(acRepairReqDTO);
        System.out.println("######"+ acRepairRepDTO);
    }
}