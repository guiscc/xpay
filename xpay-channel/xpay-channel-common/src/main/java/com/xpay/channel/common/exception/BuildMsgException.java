package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BuildMsgException extends FrontException {
	private static final long serialVersionUID = -2823749034824493534L;

    public BuildMsgException(EnumRtnResult rtnResult) {
        super(rtnResult);
    }
}
