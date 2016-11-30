/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.test.agent;

import com.xpay.channel.biz.AgentCollectBiz;
import com.xpay.channel.biz.test.BaseTest;
import com.xpay.channel.common.dto.agentcollect.ACPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACPayReqChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayReqChannelDTO;
import com.xpay.channel.common.facade.AgentCollectFacade;
import com.xpay.channel.common.vo.agentcollect.ACPayRepVO;
import com.xpay.common.enums.EnumCardType;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestAgentBiz.java, v 0.1 16/11/5 下午4:50 sxfans Exp $
 */
public class TestAgentBizPay extends BaseTest {

    @Resource
    private AgentCollectFacade agentCollectFacade;

    @Test
    public void pay() {
        ACPayReqChannelDTO acPayReqChannelDTO = new ACPayReqChannelDTO();
        acPayReqChannelDTO.setUserId("");
        acPayReqChannelDTO.setAmount(new BigDecimal(1));
        acPayReqChannelDTO.setCardNo("622000111111");
        acPayReqChannelDTO.setCardType(EnumCardType.DEBIT);
        acPayReqChannelDTO.setCreateDate(new Date());
        acPayReqChannelDTO.setCvv2("221");
        acPayReqChannelDTO.setExpireDate("1116");
        acPayReqChannelDTO.setHolderName("苏欣欣");
        ACPayRepChannelDTO acPayRepChannelDTO = agentCollectFacade.pay(acPayReqChannelDTO);
        System.out.println(acPayRepChannelDTO);
    }

    @Test
    public void payQuery(){
        ACQueryPayReqChannelDTO acQueryPayReqChannelDTO = new ACQueryPayReqChannelDTO();
        acQueryPayReqChannelDTO.setPayOrderNo("");
//        acQueryPayReqChannelDTO.setReqDateTime();
//        acQueryPayReqChannelDTO.setExtMap();
    }
}