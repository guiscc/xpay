/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.dao.entity.InstMerchantEntity;
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
 * @version $Id: InstMer_RouterHandler.java, v 0.1 16/12/1 上午11:23 sxfans Exp $
 */
public class InstMer_RouterHandler extends AbsRouterHandler {

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) throws ChannelRouterException {
        String ids = getIds(routerContext);
        List<InstMerchantEntity> list = instMerchantDao.findByInstCode(ids);
        if(CollectionUtils.isEmpty(list)){
            throw new ChannelRouterException(EnumRtnResult.E030005);
        }
        //TODO 限额,权重,处理待做
        routerContext.setInstMerchantEntity(list.get(0));
        return routerContext;
    }

    /**
     *
     * @param routerContext
     * @return
     */
    private String getIds(RouterContext routerContext) {
        StringBuilder stringBuilder = new StringBuilder();
        List<InstitutionEntity> list = routerContext.getInstitutionEntityList();
        for (InstitutionEntity item : list) {
            stringBuilder.append(item.getInstCode() + ",");
        }
        String ids = StringUtils.removeEnd(stringBuilder.toString(), ",");
        return ids;
    }
}