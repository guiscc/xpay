/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router.handler;

import com.xpay.channel.dao.*;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: AbsRouterHandler.java, v 0.1 16/12/2 上午9:38 sxfans Exp $
 */
public abstract class AbsRouterHandler implements RouterHandler {

    @Resource
    protected PayToolsMappingDao payToolsMappingDao;

    @Resource
    protected PayToolsBankDao payToolsBankDao;

    @Resource
    protected ChannelDao channelDao;

    @Resource
    protected InstituionDao instituionDao;

    @Resource
    protected InstMerchantDao instMerchantDao;
}