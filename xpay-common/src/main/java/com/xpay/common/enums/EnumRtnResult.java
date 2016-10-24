package com.xpay.common.enums;

/**
 * Created by sxfans on 16/8/21.
 */
public enum EnumRtnResult {

    S000000(EnumRtnStatus.SUCCESS, "成功"),
    U00000(EnumRtnStatus.UNKNOW, "未知异常"),

    /*00收银台*/
    /*01交易*/
    /*02核心支付*/
    /*03渠道*/
    /*04账务*/
    /*05清算*/

    /*交易E01*/
    E000000(EnumRtnStatus.FAIL, "失败"),
    E000001(EnumRtnStatus.FAIL, "查询的订单不存在"),
    E000002(EnumRtnStatus.FAIL, "修改失败"),
    E000003(EnumRtnStatus.FAIL, "订单状态失败"),
    E000004(EnumRtnStatus.FAIL, "持久化订单异常"),
    E000005(EnumRtnStatus.FAIL, "签约失败"),
    E000006(EnumRtnStatus.FAIL, "操作失败签约已经成功"),
    E000007(EnumRtnStatus.FAIL, "签约信息不存在"),
    E000008(EnumRtnStatus.FAIL, "解约失败"),
    E000009(EnumRtnStatus.FAIL, "签约失败"),

    /*核心支付E02*/

    /*渠道E03*/
    E030101(EnumRtnStatus.FAIL, "未知主机名"),
    E030102(EnumRtnStatus.FAIL, "连接超时"),
    E030103(EnumRtnStatus.UNKNOW, "读取超时"),
    E030104(EnumRtnStatus.UNKNOW, "通信超时"),

    E030201(EnumRtnStatus.FAIL, "拼装报文异常"),
    E030202(EnumRtnStatus.UNKNOW, "报文解析异常");

    EnumRtnResult(EnumRtnStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private EnumRtnStatus status;
    private String msg;

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
