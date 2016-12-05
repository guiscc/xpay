/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.dao.entity.ChannelEntity;
import com.xpay.channel.dao.entity.InstitutionEntity;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.channel.service.router.handler.AbsRouterHandler;
import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: Inst_RouterHandler.java, v 0.1 16/12/1 上午11:23 sxfans Exp $
 */
public class Inst_RouterHandler extends AbsRouterHandler {

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) throws ChannelRouterException {
        String ids = getIds(routerContext);
        List<InstitutionEntity> list = institutionDao.findByInstCodes(ids);
        if(CollectionUtils.isEmpty(list)){
            throw new ChannelRouterException(EnumRtnResult.E030004);
        }
        routerContext.setInstitutionEntityList(list);
        return routerContext;
    }

    /**
     *
     * @param routerContext
     * @return
     */
    private String getIds(RouterContext routerContext) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ChannelEntity> list = routerContext.getChannelEntityList();
        for (ChannelEntity channelEntity : list) {
            stringBuilder.append(channelEntity.getInstCode()+",");
        }
        String ids = StringUtils.removeEnd(stringBuilder.toString(),",");
        return ids;
    }
}