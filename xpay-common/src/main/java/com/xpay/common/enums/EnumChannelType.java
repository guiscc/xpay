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

    AUTH((byte) 0, "认证"),

    PAY((byte) 1, "支付"),
    PAYCALLBACK((byte) 2, "支付回调"),
    PAYQUERY((byte) 2, "支付查询"),

    REFUND((byte) 3, "退款"),
    REFUNDCALLBACK((byte) 4, "退款回调"),
    REFUNDQUERY((byte)5,"退款查询"),

    CANCEL((byte) 4, "交易撤销"),
    CANCELCALLBACK((byte)4,"撤销回调");

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