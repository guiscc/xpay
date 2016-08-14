package com.xpay.trade.common.dto;

/**
 * 订单查询请求
 * Created by sxfans on 16/8/12.
 */
public class QueryPayReqDTO extends BaseReqDTO {

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }
}
