package com.xpay.channel.common.enums;

/**
 * Created by suxinxin on 16/2/5.
 */
public enum EnumTradeType {
    SIGN("签约"),
    SIGNCONFIRM("签约确认"),
    BREAKSIGN("解约"),
    PAY("支付"),
    PAYQUERY("查询"),
    PAYCALLBACK("支付回调"),
    REFUND("退款"),
    REFUNDQUERY("查询退款"),
    REFUNDCALLBACK("退款回调"),
    CHECKFILE("对账"),

    AUTH("实名认证"),
    CANCEL("消费取消"),
    CANCELCALLBACK("取消回调"),
    ;

    EnumTradeType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
