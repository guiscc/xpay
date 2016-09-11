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
    DEBIT((byte) 0, "借记卡"),
    CREDIT((byte) 1, "贷记卡");

    EnumCardType(byte key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    /**
     * 支付工具
     *
     * @param key
     * @return
     */
    public static EnumCardType toCardType(byte key) {
        for (EnumCardType type : EnumCardType.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return null;
    }

    private byte key;
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
}