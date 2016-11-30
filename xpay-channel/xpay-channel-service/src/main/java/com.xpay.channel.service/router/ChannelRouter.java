/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;

/**
 * @author qinshou
 * @version $Id: ChannelRouter.java, v 0.1 16/11/25 下午4:16 sxfans Exp $
 */
public interface ChannelRouter<T> {

    /**
     *
     * @param req
     * @return
     */
    public RouterContext router(T req);
}