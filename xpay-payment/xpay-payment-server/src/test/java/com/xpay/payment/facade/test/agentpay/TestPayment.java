/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test.agentpay;

import com.xpay.common.enums.EnumCurrency;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import com.xpay.payment.common.dto.agentcollect.ACPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACPayReqDTO;
import com.xpay.payment.common.facade.AgentCollectFacade;
import com.xpay.payment.facade.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

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
        acRepairReqDTO.setTradeOrderNo("201609160001");
        acRepairReqDTO.setPayTool(EnumPayTool.BANKCARD);
        acRepairReqDTO.setPaySubTool(EnumPaySubTool.AGENTCOLLECT);
        acRepairReqDTO.setChannelCode("");
        acRepairReqDTO.setPayAmt(new BigDecimal("10.89"));
        acRepairReqDTO.setCurrency(EnumCurrency.CNY);
        acRepairReqDTO.setUserId("111111");
        acRepairReqDTO.setRemark("备注");
        ACPayRepDTO acPayRepDTO = collectFacade.pay(acRepairReqDTO);
        System.out.println("########" + acPayRepDTO);
    }
}