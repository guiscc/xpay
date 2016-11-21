/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.common.exception.FrontException;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayReqFrontDTO;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import com.xpay.channel.front.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestPayQuery_Union.java, v 0.1 16/11/6 下午2:49 sxfans Exp $
 */
public class TestPayQuery_Union extends BaseTest {
    @Resource
    private AgentCollectFrontFacade agentCollectFrontFacade;

    @Test
    public void queryPay() throws FrontException {
        ACQueryPayReqFrontDTO acQueryPayReqFrontDTO = new ACQueryPayReqFrontDTO();
        acQueryPayReqFrontDTO.setChannelCode("AC_UNIONPAY");
        acQueryPayReqFrontDTO.setBankOrderNo("201603300001");
        ACQueryPayRepFrontDTO acQueryPayRepFrontDTO = agentCollectFrontFacade.payQuery(acQueryPayReqFrontDTO);
        System.out.println(acQueryPayRepFrontDTO);
    }
}