package com.xpay.trade.common.vo;

/**
 * Created by sxfans on 16/8/20.
 */
public class UpOrderStatusReqVO extends BaseReqVO {

    /**
     *
     */
    private String bizOrderNo;

    /**
     *
     */
    private String orderStatus;


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
}
