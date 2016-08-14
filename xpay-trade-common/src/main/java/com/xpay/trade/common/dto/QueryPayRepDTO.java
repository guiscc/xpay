package com.xpay.trade.common.dto;

import java.math.BigDecimal;

/**
 * 查询结果返回
 * Created by sxfans on 16/8/12.
 */
public class QueryPayRepDTO extends BaseRepDTO {
    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 金额
     */
    private BigDecimal amt;

    /**
     * 业务单号
     */
    private String bizOrderNo;


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }
}
