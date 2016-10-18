/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumChannelType.java, v 0.1 16/10/18 下午4:49 sxfans Exp $
 */
public enum EnumChannelType {

    /**
     * 认证
     */
    AUTH((byte) 0, "认证"),

    /**
     * 支付
     */
    PAY((byte) 1, "支付"),

    /**
     * 支付查询
     */
    PAYQUERY((byte) 2, "支付查询"),

    /**
     * 退款
     */
    REFUND((byte) 3, "退款");

    /**
     *
     */
    private byte key;

    /**
     *
     */
    private String val;

    EnumChannelType(byte key, String val) {
        this.key = key;
        this.val = val;
    }
}