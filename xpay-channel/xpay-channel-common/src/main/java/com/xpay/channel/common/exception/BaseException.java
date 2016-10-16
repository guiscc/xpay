package com.xpay.channel.common.exception;

import com.xpay.channel.common.enums.EnumBankRtnCode;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;

/**
 * Created by suxinxin on 14/12/25.
 */
public class BaseException extends Exception {
	private static final long serialVersionUID = -1314863505852901294L;

	public BaseException() {
        super();
    }

    public BaseException(String errorCode, String errorMsg, EnumTradeStatus tradeStatus) {
        super("错误码:" + errorCode + "," + "错误信息:" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.tradeStatus = tradeStatus;
    }

    public BaseException(EnumSysRtnCode sysRtnCodeEnum, EnumTradeStatus tradeStatus){
        this(sysRtnCodeEnum.name(), sysRtnCodeEnum.getValue(),tradeStatus);
        this.sysRtnCodeEnum = sysRtnCodeEnum;
    }

    public BaseException(EnumBankRtnCode bankRtnCodeEnum,EnumTradeStatus tradeStatus){
        this(bankRtnCodeEnum.name(), bankRtnCodeEnum.getValue(),tradeStatus) ;
        this.bankRtnCodeEnum = bankRtnCodeEnum;
    }

    private String errorCode;
    private String errorMsg;
    private EnumSysRtnCode sysRtnCodeEnum;
    private EnumBankRtnCode bankRtnCodeEnum;
    private EnumTradeStatus tradeStatus;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public EnumSysRtnCode getSysRtnCodeEnum() {
        return sysRtnCodeEnum;
    }

    public EnumBankRtnCode getBankRtnCodeEnum() {
        return bankRtnCodeEnum;
    }

    public EnumTradeStatus getTradeStatus() {
        return tradeStatus;
    }
}