/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.common.exception.FrontException;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import com.xpay.channel.front.test.BaseTest;
import com.xpay.common.enums.EnumCardType;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author qinshou
 * @version $Id: TestPay_Union.java, v 0.1 16/11/6 下午2:40 sxfans Exp $
 */
public class TestPay_Union extends BaseTest {

    @Resource
    private AgentCollectFrontFacade agentCollectFrontFacade;

    @Test
    public void pay() throws FrontException {
        ACPayReqFrontDTO acPayReqFrontDTO = new ACPayReqFrontDTO();
        acPayReqFrontDTO.setHolderName("");
        acPayReqFrontDTO.setCardType(EnumCardType.CREDIT);
        acPayReqFrontDTO.setCardNo("");
        acPayReqFrontDTO.setCerNo("");

        acPayReqFrontDTO.setPayAmt(new BigDecimal(1));
        acPayReqFrontDTO.setBankOrderNo("");
        ACPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.pay(acPayReqFrontDTO);
        System.out.println(acPayRepFrontDTO);
    }
}