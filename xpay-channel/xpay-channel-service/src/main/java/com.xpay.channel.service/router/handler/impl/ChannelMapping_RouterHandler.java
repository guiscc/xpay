/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.dao.entity.PayToolsMappingEntity;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.channel.service.router.handler.AbsRouterHandler;
import com.xpay.channel.service.router.handler.RouterHandler;
import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付工具子类型的渠道映射权重信息等
 *
 * @author qinshou
 * @version $Id: ChannelMapping_RouterHandler.java, v 0.1 16/12/1 上午11:18 sxfans Exp $
 */
public class ChannelMapping_RouterHandler extends AbsRouterHandler {

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) throws ChannelRouterException {
        String payToolsBankCode = routerContext.getPayToolsBankEntity().getPayToolsBankCode();
        if(StringUtils.isBlank(payToolsBankCode)){
            throw new ChannelRouterException(EnumRtnResult.E030001);
        }
        List<PayToolsMappingEntity> list = payToolsMappingDao.find(routerContext
            .getPayToolsBankEntity().getPayToolsBankCode());

        Map<String,PayToolsMappingEntity> payToolsMapping = new HashMap<>();

        for(PayToolsMappingEntity item : list){
            payToolsMapping.put(item.getChannelCode(),item);
        }

        if(CollectionUtils.isEmpty(list)){
            throw new ChannelRouterException(EnumRtnResult.E030002);
        }
        routerContext.setPayToolsMappingMap(payToolsMapping);
        return routerContext;
    }
}