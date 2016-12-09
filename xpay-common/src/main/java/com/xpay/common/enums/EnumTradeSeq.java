/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumTradeSeq.java, v 0.1 16/12/7 下午3:32 sxfans Exp $
 */
public enum EnumTradeSeq {
    TRADE_AC("011","代收交易"),
    TRADE_QP("012","快捷交易");

    EnumTradeSeq(String key, String val) {
        this.key = key;
        this.val = val;
    }

    private String key;
    private String val;
}