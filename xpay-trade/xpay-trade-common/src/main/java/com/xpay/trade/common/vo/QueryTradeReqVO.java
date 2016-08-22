package com.xpay.trade.common.vo;

/**
 * Created by sxfans on 16/8/12.
 */
public class QueryTradeReqVO extends BaseReqVO {

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
