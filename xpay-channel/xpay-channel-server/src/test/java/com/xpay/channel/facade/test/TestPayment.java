/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.facade.test;

import com.xpay.channel.common.dto.agentcollect.ACPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACPayReqChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayReqChannelDTO;
import com.xpay.channel.common.facade.AgentCollectFacade;
import com.xpay.common.enums.*;

import com.xpay.common.utils.DateUtil;
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
    public void payQuery(){
        ACQueryPayReqChannelDTO acQueryPayReqChannelDTO = new ACQueryPayReqChannelDTO();
        acQueryPayReqChannelDTO.setPayOrderNo("20161210142332336");
        acQueryPayReqChannelDTO.setRepair(false);

        ACQueryPayRepChannelDTO acQueryPayRepChannelDTO = collectFacade.queryPay(acQueryPayReqChannelDTO);
        System.out.println(acQueryPayRepChannelDTO.toString());
    }

    @Test
    public void payment() {

        String payOrderNo = DateUtil.DateStampToStringNoSp(new Date());

//        System.out.println(payOrderNo);
        ACPayReqChannelDTO acPayReqChannelDTO = new ACPayReqChannelDTO();
        acPayReqChannelDTO.setPayOrderNo(payOrderNo);

        acPayReqChannelDTO.setHolderName("全渠道");
        acPayReqChannelDTO.setUserId("20888888001");
        acPayReqChannelDTO.setMobileNo("13552535506");

        acPayReqChannelDTO.setCertType(EnumCertType.IDCARD);
        acPayReqChannelDTO.setCertNo("341126197709218366");

        acPayReqChannelDTO.setCurrency(EnumCurrency.CNY);
        acPayReqChannelDTO.setAmount(new BigDecimal(10));
        acPayReqChannelDTO.setCardNo("6216261000000000018");
        acPayReqChannelDTO.setCardType(EnumCardType.DEBIT);
        acPayReqChannelDTO.setCvv2("221");
        acPayReqChannelDTO.setExpireDate("1116");

        acPayReqChannelDTO.setCreateDate(new Date());


        acPayReqChannelDTO.setInstCode("ICBC");
        ACPayRepChannelDTO acPayRepDTO = collectFacade.pay(acPayReqChannelDTO);
        System.out.println("########" + acPayRepDTO);
    }
}