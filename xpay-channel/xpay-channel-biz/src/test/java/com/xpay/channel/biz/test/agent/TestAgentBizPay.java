/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.test.agent;

import com.xpay.channel.biz.test.BaseTest;
import com.xpay.channel.common.dto.agentcollect.ACPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACPayReqChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayReqChannelDTO;
import com.xpay.channel.common.facade.AgentCollectFacade;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.common.enums.EnumCurrency;
import com.xpay.common.utils.DateUtil;
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

        acPayReqChannelDTO.setPayOrderNo(DateUtil.DateStampToStringNoSp(new Date()));

        acPayReqChannelDTO.setHolderName("全渠道");
        acPayReqChannelDTO.setUserId("20888888001");
        acPayReqChannelDTO.setMobileNo("13552535506");

        acPayReqChannelDTO.setCertType(EnumCertType.IDCARD);
        acPayReqChannelDTO.setCertNo("341126197709218366");

        acPayReqChannelDTO.setCurrency(EnumCurrency.CNY);
        acPayReqChannelDTO.setAmount(new BigDecimal(1));
        acPayReqChannelDTO.setCardNo("6216261000000000018");
        acPayReqChannelDTO.setCardType(EnumCardType.DEBIT);
        acPayReqChannelDTO.setCvv2("221");
        acPayReqChannelDTO.setExpireDate("1116");

        acPayReqChannelDTO.setCreateDate(new Date());

        acPayReqChannelDTO.setInstCode("ICBC");


        ACPayRepChannelDTO acPayRepChannelDTO = agentCollectFacade.pay(acPayReqChannelDTO);
        System.out.println(acPayRepChannelDTO);
    }

    @Test
    public void payQuery(){
        ACQueryPayReqChannelDTO acQueryPayReqChannelDTO = new ACQueryPayReqChannelDTO();
        acQueryPayReqChannelDTO.setPayOrderNo("20161208164454333");

        ACQueryPayRepChannelDTO acQueryPayRepChannelDTO = agentCollectFacade.queryPay(acQueryPayReqChannelDTO);
        System.out.println(acQueryPayRepChannelDTO.toString());
    }
}