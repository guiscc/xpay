/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto;

/**
 * @author qinshou
 * @version $Id: BaseRepFrontDTO.java, v 0.1 16/10/18 下午3:02 sxfans Exp $
 */
public class BaseRepFrontDTO {
    /**
     * 返回码
     */
    private String bankRtnCode;

    /**
     * 返回信息
     */
    private String bankRtnMsg;

    /**
     * 签名
     */
    private String sign;

    /**
     * Getter method for property bankRtnCode.
     *
     * @return property value of bankRtnCode
     **/
    public String getBankRtnCode() {
        return bankRtnCode;
    }

    /**
     * Setter method for property bankRtnCode.
     *
     * @param bankRtnCode value to be assigned to property bankRtnCode
     **/
    public void setBankRtnCode(String bankRtnCode) {
        this.bankRtnCode = bankRtnCode;
    }

    /**
     * Getter method for property bankRtnMsg.
     *
     * @return property value of bankRtnMsg
     **/
    public String getBankRtnMsg() {
        return bankRtnMsg;
    }

    /**
     * Setter method for property bankRtnMsg.
     *
     * @param bankRtnMsg value to be assigned to property bankRtnMsg
     **/
    public void setBankRtnMsg(String bankRtnMsg) {
        this.bankRtnMsg = bankRtnMsg;
    }

    /**
     * Getter method for property sign.
     *
     * @return property value of sign
     **/
    public String getSign() {
        return sign;
    }

    /**
     * Setter method for property sign.
     *
     * @param sign value to be assigned to property sign
     **/
    public void setSign(String sign) {
        this.sign = sign;
    }
}