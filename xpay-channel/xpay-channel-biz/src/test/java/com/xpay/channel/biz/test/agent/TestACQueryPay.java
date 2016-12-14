/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.test.agent;

import com.xpay.channel.biz.test.BaseTest;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayReqChannelDTO;
import com.xpay.channel.common.facade.AgentCollectFacade;
import com.xpay.common.enums.EnumRtnResult;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * 查询测试用例
 * @author qinshou
 * @version $Id: TestACQueryPay.java, v 0.1 16/12/9 上午9:22 sxfans Exp $
 */
public class TestACQueryPay extends BaseTest{

    @Resource
    private AgentCollectFacade agentCollectFacade;

    /**
     * 查询成功订单
     */
    @Test
    public void payQuery(){
        ACQueryPayReqChannelDTO acQueryPayReqChannelDTO = new ACQueryPayReqChannelDTO();
        acQueryPayReqChannelDTO.setPayOrderNo("20161210142332336");
        acQueryPayReqChannelDTO.setRepair(true);

        ACQueryPayRepChannelDTO acQueryPayRepChannelDTO = agentCollectFacade.queryPay(acQueryPayReqChannelDTO);
        System.out.println(acQueryPayRepChannelDTO.toString());
    }

    /**
     * 查询成功订单-补单
     */
    @Test
    public void payQueryRepair(){

    }

    /**
     * 查询未知订单补单
     */
    @Test
    public void payQueryRepairUnknow(){

        ACQueryPayReqChannelDTO acQueryPayReqChannelDTO = new ACQueryPayReqChannelDTO();
        acQueryPayReqChannelDTO.setPayOrderNo("20161210142902706");
        acQueryPayReqChannelDTO.setRepair(true);

        ACQueryPayRepChannelDTO acQueryPayRepChannelDTO = agentCollectFacade.queryPay(acQueryPayReqChannelDTO);
        System.out.println(acQueryPayRepChannelDTO.toString());
    }

    /**
     * 查询不存在的订单
     * 预期的返回状态：  E000001(EnumRtnStatus.FAIL, "查询的订单不存在"),
     */
    @Test
    public void payQueryNoExists(){
        ACQueryPayReqChannelDTO acQueryPayReqChannelDTO = new ACQueryPayReqChannelDTO();
        acQueryPayReqChannelDTO.setPayOrderNo("20171208164454333");
        acQueryPayReqChannelDTO.setRepair(true);

        ACQueryPayRepChannelDTO acQueryPayRepChannelDTO = agentCollectFacade.queryPay(acQueryPayReqChannelDTO);
        Assert.assertEquals(acQueryPayRepChannelDTO.getRtnResult(), EnumRtnResult.E000001);
    }
}