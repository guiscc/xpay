/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler.impl;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.dao.entity.PayToolsBankEntity;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.channel.service.router.handler.AbsRouterHandler;
import com.xpay.common.enums.EnumRtnResult;

/**
 * 支付工具子类型对应的银行
 *
 * @author qinshou
 * @version $Id: PayToolsBank_RouterHandler.java, v 0.1 16/12/1 上午11:21 sxfans Exp $
 */
public class PayToolsBank_RouterHandler extends AbsRouterHandler {

    @Override
    public RouterContext routerHandler(RouterContext routerContext, RouterParam routerParam) throws ChannelRouterException {

        PayToolsBankEntity payToolsBankEntity = payToolsBankDao.get(routerParam.getPayTools()
            .getKey(), routerParam.getPaySubTools().getKey(), routerParam.getCardType().getKey(), routerParam.getInstCode());
        if(payToolsBankEntity == null){
            throw new ChannelRouterException(EnumRtnResult.E030000);
        }
        routerContext.setPayToolsBankEntity(payToolsBankEntity);
        return routerContext;
    }
}