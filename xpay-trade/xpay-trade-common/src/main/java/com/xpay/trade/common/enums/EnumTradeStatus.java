package com.xpay.trade.common.enums;

/**
 * Created by sxfans on 16/8/21.
 */
public enum EnumTradeStatus {
    /**
     * 等待付款
     */
    WATING((byte) 0, "等待付款"),

    /**
     * 支付完成
     */
    SUCCESS((byte) 1, "支付完成"),

    /**
     * 支付失败
     */
    FAIL((byte) 2, "支付失败");

    private byte key;
    private String val;

    EnumTradeStatus(byte key, String val) {
        this.key = key;
        this.val = val;
    }

    public static EnumTradeStatus toTradeStatus(byte key) {
        for (EnumTradeStatus type : EnumTradeStatus.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return null;
    }

    public byte getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }
}
