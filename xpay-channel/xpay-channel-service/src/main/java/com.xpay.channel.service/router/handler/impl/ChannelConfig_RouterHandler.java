/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.dao.entity.ChannelCfgEntity;
import com.xpay.channel.dao.entity.ChannelEntity;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.channel.service.router.handler.AbsRouterHandler;
import com.xpay.channel.service.router.handler.RouterHandler;
import com.xpay.common.enums.EnumRtnResult;

/**
 * @author qinshou
 * @version $Id: ChannelConfig_RouterHandler.java, v 0.1 16/12/1 上午11:20 sxfans Exp $
 */
public class ChannelConfig_RouterHandler extends AbsRouterHandler {

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) throws ChannelRouterException {
        ChannelEntity channelEntity = routerContext.getChannelEntity();
        ChannelCfgEntity channelCfgEntity = channelCfgDao.get(channelEntity.getChannelCode());
        if(channelCfgEntity == null){
            throw new ChannelRouterException(EnumRtnResult.E000000);
        }
        return routerContext;
    }
}