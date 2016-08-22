package com.xpay.trade.common.dto;

import java.math.BigDecimal;

/**
 * 收单返回bean
 * Created by sxfans on 16/8/12.
 */
public class TradeRepDTO extends BaseRepDTO {

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    /**
     * 交易订单号
     */
    private String tradeOrderNo;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 金额
     */
    private BigDecimal amt;

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

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

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }
}
