/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.admin.common.exception;

import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.exception.BaseException;

/**
 * @author qinshou
 * @version $Id: XpayAdminException.java, v 0.1 16/12/13 上午11:41 sxfans Exp $
 */
public class XpayAdminException extends BaseException{


    public XpayAdminException() {
        super();
    }

    public XpayAdminException(String msg) {
        super();
    }

    public XpayAdminException(EnumRtnResult rtnResult) {
        super(rtnResult.name(), rtnResult.getMsg(), rtnResult.getStatus());
        this.setRtnResult(rtnResult);
        this.setErrorCode(rtnResult.name());
        this.setErrorMsg(rtnResult.getMsg());
        this.setRtnStatus(rtnResult.getStatus());
    }

    private String errorCode;

    /**
     * Getter method for property errorCode.
     *
     * @return property value of errorCode
     **/
    @Override
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property errorCode.
     *
     * @param errorCode value to be assigned to property errorCode
     **/
    @Override
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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