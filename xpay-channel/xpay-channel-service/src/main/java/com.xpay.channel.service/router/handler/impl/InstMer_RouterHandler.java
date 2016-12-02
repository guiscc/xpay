/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.channel.service.router.handler.RouterHandler;

/**
 * @author qinshou
 * @version $Id: InstMer_RouterHandler.java, v 0.1 16/12/1 上午11:23 sxfans Exp $
 */
public class InstMer_RouterHandler implements RouterHandler{

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) {
        System.out.println("###################机构商户路由");
        return routerContext;
    }
}