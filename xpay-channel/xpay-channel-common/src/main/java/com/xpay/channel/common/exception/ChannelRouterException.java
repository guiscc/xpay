/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;

/**
 * 渠道路由异常
 * @author qinshou
 * @version $Id: ChannelRouterException.java, v 0.1 16/12/2 下午12:01 sxfans Exp $
 */
public class ChannelRouterException extends XpayChannelException{

    public ChannelRouterException(EnumRtnResult rtnResult) {
        super(rtnResult);
    }
}