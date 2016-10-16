/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.exception;

import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.exception.BaseException;

/**
 * @author qinshou
 * @version $Id: XpayChannelException.java, v 0.1 16/9/10 上午11:45 sxfans Exp $
 */
public class XpayChannelException extends BaseException{
    public XpayChannelException() {
        super();
    }

    public XpayChannelException(EnumRtnResult rtnResult) {
        super(rtnResult.name(), rtnResult.getMsg(), rtnResult.getStatus());
        this.setRtnResult(rtnResult);
        this.setErrorCode(rtnResult.name());
        this.setErrorMsg(rtnResult.getMsg());
        this.setRtnStatus(rtnResult.getStatus());
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