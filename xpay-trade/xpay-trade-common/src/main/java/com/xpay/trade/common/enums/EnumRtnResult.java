package com.xpay.trade.common.enums;

/**
 * Created by sxfans on 16/8/21.
 */
public enum EnumRtnResult {

    /**
     * 成功
     */
    S000000("SUCCESS", "成功"),

    /**
     * 交易系统失败
     */
    E000000("FAIL", "失败"),

    /**
     * 外围系统失败
     */
    U00000("UNKNOW", "未知异常");

    EnumRtnResult(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static final String UNKNOW = "UNKNOW";

    private String status;
    private String msg;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
