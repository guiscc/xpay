/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;

import com.xpay.channel.common.exception.ChannelRouterException;

/**
 * 路由策略接口
 * @author qinshou
 * @version $Id: ChannelRouter.java, v 0.1 16/11/25 下午4:16 sxfans Exp $
 */
public interface ChannelRouter {

    /**
     * 根据路由参数进行渠道路由
     * @param routerParam
     * @return
     */
    public RouterContext router(RouterParam routerParam) throws ChannelRouterException;
}