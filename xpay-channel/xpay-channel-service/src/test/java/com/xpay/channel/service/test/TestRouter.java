/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.test;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.service.router.ChannelRouter;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author qinshou
 * @version $Id: TestRouter.java, v 0.1 16/12/5 下午4:37 sxfans Exp $
 */
public class TestRouter extends BaseTest{

    @Resource
    ChannelRouter channelRouter;

    @Test
    public void router() throws ChannelRouterException {
        RouterParam routerParam = new RouterParam();
        routerParam.setPayAmt(new BigDecimal(100));
        routerParam.setCardType(EnumCardType.DEBIT);
        routerParam.setInstCode("ABC");
        routerParam.setPayTools(EnumPayTool.BANKCARD);
        routerParam.setPaySubTools(EnumPaySubTool.NETBANK);

        RouterContext routerContext = channelRouter.router(routerParam);
        System.out.println(routerContext);
    }
}