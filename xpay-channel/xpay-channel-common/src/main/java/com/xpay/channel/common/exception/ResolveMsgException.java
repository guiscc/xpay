package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;

/**
 * Created by suxinxin on 16/2/5.
 */
public class ResolveMsgException extends XpayChannelException {
    private static final long serialVersionUID = -3140443782902357578L;

    public ResolveMsgException(EnumRtnResult rtnResult) {
        super(rtnResult);
    }
}
