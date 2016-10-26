/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;

/**
 * @author qinshou
 * @version $Id: FrontException.java, v 0.1 16/10/26 下午3:39 sxfans Exp $
 */
public class FrontException extends XpayChannelException {

    public FrontException(EnumRtnResult rtnResult) {
        super(rtnResult);
    }
}