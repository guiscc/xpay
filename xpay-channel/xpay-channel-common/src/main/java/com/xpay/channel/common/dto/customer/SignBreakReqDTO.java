/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.customer;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.xpay.channel.common.dto.BaseReqDTO;

/**
 * @author qinshou
 * @version $Id: SignBreakReqDTO.java, v 0.1 16/9/6 下午4:19 sxfans Exp $
 */
public class SignBreakReqDTO extends BaseReqDTO {

    /**
     * 签约号
     */
    private String signNo;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}