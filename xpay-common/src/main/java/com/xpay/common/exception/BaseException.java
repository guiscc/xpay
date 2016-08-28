/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.exception;

import com.xpay.common.enums.EnumRtnStatus;

/**
 * @author qinshou
 * @version $Id: BaseException.java, v 0.1 16/8/27 下午2:24 sxfans Exp $
 */
public class BaseException extends Exception {

    public BaseException() {
        super();
    }

    public BaseException(String errorCode, String errorMsg, EnumRtnStatus enumRtnStatus) {
        super("处理状态:" + enumRtnStatus + ",错误码:" + errorCode + "错误信息:" + errorMsg);
    }

    /**
     * 错误码
     */
    private String        errorCode;

    /**
     * 错误消息
     */
    private String        errorMsg;

    /**
     * 交易状态
     */
    private EnumRtnStatus rtnStatus;

    /**
     * Getter method for property errorCode.
     *
     * @return property value of errorCode
     **/
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property errorCode.
     *
     * @param errorCode value to be assigned to property errorCode
     **/
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property errorMsg.
     *
     * @return property value of errorMsg
     **/
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Setter method for property errorMsg.
     *
     * @param errorMsg value to be assigned to property errorMsg
     **/
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * Getter method for property rtnStatus.
     *
     * @return property value of rtnStatus
     **/
    public EnumRtnStatus getRtnStatus() {
        return rtnStatus;
    }

    /**
     * Setter method for property rtnStatus.
     *
     * @param rtnStatus value to be assigned to property rtnStatus
     **/
    public void setRtnStatus(EnumRtnStatus rtnStatus) {
        this.rtnStatus = rtnStatus;
    }
}