/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumCurrency.java, v 0.1 16/8/30 上午1:02 sxfans Exp $
 */
public enum EnumCurrency {
    CNY((byte) 0, "人民币");

    private byte key = 0;
    private String msg = "";

    public static EnumCurrency toCurrency(byte key) {
        for (EnumCurrency type : EnumCurrency.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return null;
    }

    EnumCurrency(byte key, String msg) {
        this.key = key;
        this.msg = msg;
    }

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