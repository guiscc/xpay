/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.common.exception.FrontException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import com.xpay.channel.front.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestPay_Union.java, v 0.1 16/11/23 上午1:36 sxfans Exp $
 */
public class TestPay_Union extends BaseTest {
    @Resource
    private AgentCollectFrontFacade agentCollectFrontFacade;

    @Test
    public void pay() throws FrontException {
        ACPayReqFrontDTO reqDto = new ACPayReqFrontDTO();
        reqDto.setReqDateTime(new Date());
        reqDto.setCardNo("6216261000000000018");
        reqDto.setHolderName("全渠道");
        reqDto.setCertNo("341126197709218366");
        reqDto.setMobileNo("13552535506");
        String channelOrderNo = DateUtil.DateStampToStringNoSp(new Date());
        reqDto.setBankOrderNo(channelOrderNo);
        reqDto.setPayAmt(new BigDecimal(5));
        reqDto.setChannelCode("AC_UNIONPAY");
        ACPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.pay(reqDto);
        System.out.println("###########"+acPayRepFrontDTO);
    }



}