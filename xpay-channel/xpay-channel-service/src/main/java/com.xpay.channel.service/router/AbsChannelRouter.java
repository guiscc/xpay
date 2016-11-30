/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;

/**
 * @author qinshou
 * @version $Id: AbsChannelRouter.java, v 0.1 16/11/30 上午9:45 sxfans Exp $
 */
public class AbsChannelRouter<T> implements ChannelRouter<T> {

    @Override
    public RouterContext router(T req) {
        return null;
    }
}