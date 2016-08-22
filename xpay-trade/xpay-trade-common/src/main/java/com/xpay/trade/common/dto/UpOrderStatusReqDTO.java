package com.xpay.trade.common.dto;

/**
 * Created by sxfans on 16/8/19.
 */
public class UpOrderStatusReqDTO extends BaseReqDTO{

    /**
     * 订单状态
     */
    private String orderStatus;

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

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }
}
