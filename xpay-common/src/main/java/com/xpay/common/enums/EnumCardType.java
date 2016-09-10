/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumCardType.java, v 0.1 16/8/31 下午6:40 sxfans Exp $
 */
public enum EnumCardType {
    DEBIT("借记卡"),
    CREDIT("贷记卡");

    EnumCardType(String msg) {
        this.msg = msg;
    }

    private String msg;

    /**
     * Getter method for property msg.
     *
     * @return property value of msg
     **/
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property msg.
     *
     * @param msg value to be assigned to property msg
     **/
    public void setMsg(String msg) {
        this.msg = msg;
    }
}