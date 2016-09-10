/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumPaySubTool.java, v 0.1 16/8/30 下午12:41 sxfans Exp $
 */
public enum EnumPaySubTool {
    NETBANK((byte) 1, "网银"),
    AGENTCOLLECT((byte) 0, "代收"),
    QUICKPAY((byte) 2, "快捷");

    private byte key;
    private String val;

    EnumPaySubTool(byte key, String val) {
        this.key = key;
        this.val = val;
    }

    /**
     * 支付工具
     *
     * @param key
     * @return
     */
    public static EnumPaySubTool toPaySubTool(byte key) {
        for (EnumPaySubTool type : EnumPaySubTool.values()) {
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