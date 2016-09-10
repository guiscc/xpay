/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumPayTool.java, v 0.1 16/8/30 下午12:40 sxfans Exp $
 */
public enum EnumPayTool {

    BANKCARD((byte) 0, "银行卡支付工具");

    EnumPayTool(byte key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    /**
     *
     */
    private byte   key;

    /**
     *
     */
    private String msg;

    /**
     * 支付工具
     * @param key
     * @return
     */
    public static EnumPayTool toPayTool(byte key) {
        for (EnumPayTool type : EnumPayTool.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return null;
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