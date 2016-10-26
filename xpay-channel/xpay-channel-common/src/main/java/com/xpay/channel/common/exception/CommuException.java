package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;

/**
 * Created by suxinxin on 16/2/5.
 */
public class CommuException extends FrontException {
	private static final long serialVersionUID = 309287229027722019L;

    public CommuException(EnumRtnResult rtnResult) {
        super(rtnResult);
    }
}
