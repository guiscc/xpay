package com.xpay.channel.common.exception;

import com.xpay.channel.common.enums.EnumBankRtnCode;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;

/**
 * Created by suxinxin on 16/2/5.
 */
public class VldException extends BaseException {
	private static final long serialVersionUID = -6085937203093705881L;

	public VldException(String errorCode, String errorMsg, EnumTradeStatus tradeStatus) {
        super(errorCode, errorMsg, tradeStatus);
    }

    public VldException(EnumSysRtnCode sysRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(sysRtnCodeEnum, tradeStatus);
    }

    public VldException(EnumBankRtnCode bankRtnCodeEnum, EnumTradeStatus tradeStatus) {
        super(bankRtnCodeEnum, tradeStatus);
    }
}
