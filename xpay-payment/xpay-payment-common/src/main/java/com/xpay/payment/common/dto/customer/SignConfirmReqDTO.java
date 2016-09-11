/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.customer;

import com.xpay.payment.common.dto.BaseReqDTO;

/**
 * @author qinshou
 * @version $Id: SignConfirmReqVO.java, v 0.1 16/9/6 下午4:12 sxfans Exp $
 */
public class SignConfirmReqDTO extends BaseReqDTO{

    /**
     * 签约号
     */
    private String signNo;

    /**
     * 短信验证码
     */
    private String verifyCode;

    /**
     * Getter method for property signNo.
     *
     * @return property value of signNo
     **/
    public String getSignNo() {
        return signNo;
    }

    /**
     * Setter method for property signNo.
     *
     * @param signNo value to be assigned to property signNo
     **/
    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    /**
     * Getter method for property verifyCode.
     *
     * @return property value of verifyCode
     **/
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * Setter method for property verifyCode.
     *
     * @param verifyCode value to be assigned to property verifyCode
     **/
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}