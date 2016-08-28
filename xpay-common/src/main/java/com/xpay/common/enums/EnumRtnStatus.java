package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumRtnStatus.java, v 0.1 16/8/27 下午4:40 sxfans Exp $
 */
public enum EnumRtnStatus {
    SUCCESS("请求操作成功"), FAIL("请求操作失败"), UNKNOW("请求操作异常");

    private String msg = "";

    EnumRtnStatus(String msg) {
        this.msg = msg;
    }

    /**
     * Getter method for property msg.
     *
     * @return property value of msg
     **/
    public String getMsg() {
        return msg;
    }
}