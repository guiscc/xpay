package com.xpay.channel.common.exception;

import com.xpay.channel.common.enums.EnumBankRtnCode;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BuildMsgException extends BaseException {
	private static final long serialVersionUID = -2823749034824493534L;

	public BuildMsgException(String errorCode, String errorMsg, EnumTradeStatus tradeStatus) {
        super(errorCode, errorMsg, tradeStatus);
    }

    public BuildMsgException(EnumSysRtnCode sysRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(sysRtnCodeEnum, tradeStatus);
    }

    public BuildMsgException(EnumBankRtnCode bankRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(bankRtnCodeEnum, tradeStatus);
    }
}
