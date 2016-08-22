package com.xpay.trade.common.enums;

/**
 * Created by sxfans on 16/8/21.
 */
public enum EnumTradeType {
    MEMBER((byte) 1, "会员交易"),
    ACQUIRING((byte) 2, "收单交易"),
    REFUND((byte) 3, "退款交易"),
    PAYMENT((byte) 4, "代付交易"),
    TICKETREFUND((byte) 5, "退票交易");

    private byte key;
    private String val;

    EnumTradeType(byte key, String val) {
        this.key = key;
        this.val = val;
    }

    public static EnumTradeType toTradeType(byte key) {
        for (EnumTradeType type : EnumTradeType.values()) {
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
