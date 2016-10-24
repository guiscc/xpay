/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumRefundStatus.java, v 0.1 16/10/23 下午1:06 sxfans Exp $
 */
public enum EnumRefundStatus {
    FAIL((byte) 0, "支付失败"),

    SUCCESS((byte) 1, "支付成功"),

    PROCESS((byte) 3, "等待付款"),

    UNKNOW((byte) 4, "未知");

    EnumRefundStatus(byte key, String val) {
        this.key = key;
        this.val = val;
    }

    private byte key;

    private String val;

    /**
     * Getter method for property key.
     *
     * @return property value of key
     **/
    public byte getKey() {
        return key;
    }

    /**
     * Setter method for property key.
     *
     * @param key value to be assigned to property key
     **/
    public void setKey(byte key) {
        this.key = key;
    }

    /**
     * Getter method for property val.
     *
     * @return property value of val
     **/
    public String getVal() {
        return val;
    }

    /**
     * Setter method for property val.
     *
     * @param val value to be assigned to property val
     **/
    public void setVal(String val) {
        this.val = val;
    }
}