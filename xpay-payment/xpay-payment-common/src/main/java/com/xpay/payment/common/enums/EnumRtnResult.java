/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.enums;

import com.xpay.common.enums.EnumRtnStatus;

/**
 * @author qinshou
 * @version $Id: EnumRtnResult.java, v 0.1 16/8/31 下午5:16 sxfans Exp $
 */
public enum EnumRtnResult {
    S000000(EnumRtnStatus.SUCCESS, "成功"),
    E000000(EnumRtnStatus.FAIL, "失败"),
    E000001(EnumRtnStatus.FAIL, "查询的订单不存在"),
    E000002(EnumRtnStatus.FAIL, "修改失败"),
    E000003(EnumRtnStatus.FAIL, "订单状态失败"),
    U00000(EnumRtnStatus.UNKNOW, "未知异常");

    /**
     * 返回状态
     */
    private EnumRtnStatus rtnStatus;

    /**
     * 金额描述
     */
    private String msg;

    EnumRtnResult(EnumRtnStatus rtnStatus, String msg) {
        this.rtnStatus = rtnStatus;
        this.msg = msg;
    }

    /**
     * Getter method for property rtnStatus.
     *
     * @return property value of rtnStatus
     **/
    public EnumRtnStatus getRtnStatus() {
        return rtnStatus;
    }

    /**
     * Setter method for property rtnStatus.
     *
     * @param rtnStatus value to be assigned to property rtnStatus
     **/
    public void setRtnStatus(EnumRtnStatus rtnStatus) {
        this.rtnStatus = rtnStatus;
    }

    /**
     * Getter method for property msg.
     *
     * @return property value of msg
     **/
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property msg.
     *
     * @param msg value to be assigned to property msg
     **/
    public void setMsg(String msg) {
        this.msg = msg;
    }
}