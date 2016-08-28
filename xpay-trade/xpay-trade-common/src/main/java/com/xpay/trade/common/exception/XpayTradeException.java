package com.xpay.trade.common.exception;

import com.xpay.common.exception.BaseException;
import com.xpay.trade.common.enums.EnumRtnResult;

public class XpayTradeException extends BaseException {

    public XpayTradeException() {
        super();
    }

    public XpayTradeException(EnumRtnResult enumRtnResult) {
        super(enumRtnResult.name(), enumRtnResult.getMsg(), enumRtnResult.getStatus());
        this.setRtnResult(enumRtnResult);
        this.setErrorCode(enumRtnResult.name());
        this.setErrorMsg(enumRtnResult.getMsg());
        this.setRtnStatus(enumRtnResult.getStatus());
    }

    /**
     * 返回信息
     */
    private EnumRtnResult rtnResult;

    /**
     * Getter method for property rtnResult.
     *
     * @return property value of rtnResult
     **/
    public EnumRtnResult getRtnResult() {
        return rtnResult;
    }

    /**
     * Setter method for property rtnResult.
     *
     * @param rtnResult value to be assigned to property rtnResult
     **/
    public void setRtnResult(EnumRtnResult rtnResult) {
        this.rtnResult = rtnResult;
    }
}