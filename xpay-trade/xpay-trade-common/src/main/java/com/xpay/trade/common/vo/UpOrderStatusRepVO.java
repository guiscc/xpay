package com.xpay.trade.common.vo;

import com.xpay.trade.common.enums.EnumTradeStatus;

/**
 * Created by sxfans on 16/8/20.
 */
public class UpOrderStatusRepVO extends BaseRepVO {

    /**
     *
     */
    private String bizOrderNo;

    /**
     *
     */
    private EnumTradeStatus orderStatus;

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public EnumTradeStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EnumTradeStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
