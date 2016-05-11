package com.xpay.channel.common.enums;

/**
 * Created by suxinxin on 16/2/5.
 */
public enum EnumTradeStatus {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    PROCESS(2, "处理中"),
    UNKNOW(3, "未知");

    private int key;
    private String value;

    EnumTradeStatus(int key, String val) {
        this.key = key;
        this.value = val;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
