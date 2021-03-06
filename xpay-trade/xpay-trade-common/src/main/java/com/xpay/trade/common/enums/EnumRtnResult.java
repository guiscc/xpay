package com.xpay.trade.common.enums;

import com.xpay.common.enums.EnumRtnStatus;

/**
 * Created by sxfans on 16/8/21.
 */
public enum EnumRtnResult {

    S000000(EnumRtnStatus.SUCCESS, "成功"),

    E000000(EnumRtnStatus.FAIL, "失败"),
    E000001(EnumRtnStatus.FAIL, "查询的订单不存在"),
    E000002(EnumRtnStatus.FAIL, "修改失败"),
    E000003(EnumRtnStatus.FAIL, "订单状态失败"),

    U00000(EnumRtnStatus.UNKNOW, "未知异常");

    EnumRtnResult(EnumRtnStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private EnumRtnStatus status;
    private String        msg;

    /**
     * Getter method for property status.
     *
     * @return property value of status
     **/
    public EnumRtnStatus getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
