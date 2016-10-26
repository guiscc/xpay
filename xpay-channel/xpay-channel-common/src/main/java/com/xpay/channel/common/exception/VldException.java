package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;

/**
 * Created by suxinxin on 16/2/5.
 */
public class VldException extends FrontException {
	private static final long serialVersionUID = -6085937203093705881L;

    public VldException(EnumRtnResult rtnResult) {
        super(rtnResult);
    }
}
