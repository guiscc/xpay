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
import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * 读支付工具子类型银行所支持的渠道集合
 *
 * @author qinshou
 * @version $Id: Channel_RouterHandler.java, v 0.1 16/12/2 下午2:15 sxfans Exp $
 */
public class Channel_RouterHandler extends AbsRouterHandler{

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam)
            throws ChannelRouterException {
        String str = getIds(routerContext);
        List<ChannelEntity> list = channelDao.findByChannelCode(str);
        if(CollectionUtils.isEmpty(list)){
            throw new ChannelRouterException(EnumRtnResult.E000000);
        }
        routerContext.setChannelEntityList(list);
        return null;
    }

    /**
     *
     * @param routerContext
     * @return
     */
    private String getIds(RouterContext routerContext){
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> keySet = routerContext.getPayToolsMappingMap().keySet();
        for(String item : keySet){
            stringBuilder.append(item+",");
        }
        String ids =StringUtils.removeEnd(stringBuilder.toString(),",");
        return ids;
    }
}