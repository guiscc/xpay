package com.xpay.trade.common.dto;

import com.xpay.trade.common.enums.EnumTradeStatus;

/**
 * Created by sxfans on 16/8/19.
 */
public class UpOrderStatusReqDTO extends BaseReqDTO{

    /**
     * 订单状态
     */
    private EnumTradeStatus orderStatus;

    /**
     * 业务单号
     */
    private String bizOrderNo;

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

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }
}
