/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.dao.entity.ChannelEntity;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.channel.service.router.handler.AbsRouterHandler;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: ChannelWeight_RouterHandler.java, v 0.1 16/12/2 下午7:53 sxfans Exp $
 */
public class ChannelWeight_RouterHandler extends AbsRouterHandler{

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam)
            throws ChannelRouterException {
        List<ChannelEntity> list = routerContext.getChannelEntityList();
        ChannelEntity channelEntity = list.get(0);
        routerContext.setChannelEntity(channelEntity);
        return routerContext;
    }
}