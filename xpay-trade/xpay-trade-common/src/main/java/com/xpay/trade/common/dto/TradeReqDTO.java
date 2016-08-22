package com.xpay.trade.common.dto;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeReqDTO extends BaseReqDTO {

    /**
     * 交易号
     */
    private String tradeOrderNo;

    /**
     * 订单时间
     */
    private String orderTime;

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 子业务类型
     */
    private String bizSubType;

    /**
     * 交易金额
     */
    private String payAmt;

    /**
     * 商品名称
     */
    private String goodsName;

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizSubType() {
        return bizSubType;
    }

    public void setBizSubType(String bizSubType) {
        this.bizSubType = bizSubType;
    }

    public String getPayAmt() {
        return payAmt;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }
}
