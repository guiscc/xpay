package com.xpay.channel.common.exception;

import com.xpay.channel.common.enums.EnumBankRtnCode;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;

/**
 * Created by suxinxin on 16/2/5.
 */
public class CommuException extends BaseException {
	private static final long serialVersionUID = 309287229027722019L;

	public CommuException(String errorCode, String errorMsg, EnumTradeStatus tradeStatus) {
        super(errorCode, errorMsg, tradeStatus);
    }

    public CommuException(EnumSysRtnCode sysRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(sysRtnCodeEnum, tradeStatus);
    }

    public CommuException(EnumBankRtnCode bankRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(bankRtnCodeEnum, tradeStatus);
    }
}
