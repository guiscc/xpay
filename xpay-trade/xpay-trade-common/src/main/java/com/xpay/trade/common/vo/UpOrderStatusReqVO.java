package com.xpay.trade.common.vo;

import com.xpay.trade.common.enums.EnumTradeStatus;

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
    private EnumTradeStatus orderStatus;


    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    /**
     * Getter method for property orderStatus.
     *
     * @return property value of orderStatus
     **/
    public EnumTradeStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Setter method for property orderStatus.
     *
     * @param orderStatus value to be assigned to property orderStatus
     **/
    public void setOrderStatus(EnumTradeStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
