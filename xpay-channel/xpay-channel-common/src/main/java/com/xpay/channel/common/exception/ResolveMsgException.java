package com.xpay.channel.common.exception;

import com.xpay.channel.common.enums.EnumBankRtnCode;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;

/**
 * Created by suxinxin on 16/2/5.
 */
public class ResolveMsgException extends BaseException {
	private static final long serialVersionUID = -3140443782902357578L;

	public ResolveMsgException(String errorCode, String errorMsg, EnumTradeStatus tradeStatus) {
        super(errorCode, errorMsg, tradeStatus);
    }

    public ResolveMsgException(EnumSysRtnCode sysRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(sysRtnCodeEnum, tradeStatus);
    }

    public ResolveMsgException(EnumBankRtnCode bankRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(bankRtnCodeEnum, tradeStatus);
    }
}
