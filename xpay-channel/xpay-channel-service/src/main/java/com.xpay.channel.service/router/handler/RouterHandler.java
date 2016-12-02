/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;

/**
 * @author qinshou
 * @version $Id: RouterHandler.java, v 0.1 16/12/1 上午10:55 sxfans Exp $
 */
public interface RouterHandler {

    /**
     * 路由实体
     * @param routerContext
     * @return
     */
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) throws ChannelRouterException;
}