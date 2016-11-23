/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.common.exception.FrontException;
import com.xpay.channel.common.util.DateUtil;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqFrontDTO;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import com.xpay.channel.front.facade.CustomerFrontFacade;
import com.xpay.channel.front.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestAuth_Union.java, v 0.1 16/11/23 下午10:34 sxfans Exp $
 */
public class TestAuth_Union extends BaseTest{


    @Resource
    private CustomerFrontFacade customerFrontFacade;

    @Test
    public void auth() throws FrontException {
        RealNameAuthReqFrontDTO realNameAuthReqFrontDTO = new RealNameAuthReqFrontDTO();
        realNameAuthReqFrontDTO.setCardNo("6216261000000000018");
        realNameAuthReqFrontDTO.setHolderName("全渠道");
        realNameAuthReqFrontDTO.setCertNo("341126197709218366");
        realNameAuthReqFrontDTO.setMobileNo("13552535506");
        realNameAuthReqFrontDTO.setBankAuthrNo(DateUtil.DateStampToStringNoSp(new Date()));
        realNameAuthReqFrontDTO.setChannelCode("AC_UNIONPAY");
        RealNameAuthRepFrontDTO aa = customerFrontFacade.auth(realNameAuthReqFrontDTO);
        System.out.println(aa);
    }
}