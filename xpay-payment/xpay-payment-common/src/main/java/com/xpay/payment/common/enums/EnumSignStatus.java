/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumSignStatus.java, v 0.1 16/9/10 上午11:02 sxfans Exp $
 */
public enum EnumSignStatus {
    SIGN_FAIL((byte) 0, "签约失败"),

    SIGN_SUCCESS((byte) 1, "签约成功"),

    SIGN_WAITING((byte) 3, "签约未确认"),

    BREAKSIGN_SUCCESS((byte) 4, "解约成功");

    public static EnumSignStatus toSignStatus(byte key) {
        for (EnumSignStatus type : EnumSignStatus.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return null;
    }

    /**
     *
     */
    private byte key;

    /**
     *
     */
    private String msg;

    EnumSignStatus(byte key, String msg) {
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
}