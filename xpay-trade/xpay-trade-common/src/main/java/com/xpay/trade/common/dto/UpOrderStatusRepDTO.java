package com.xpay.trade.common.dto;

import com.xpay.trade.common.enums.EnumTradeStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by sxfans on 16/8/19.
 */
public class UpOrderStatusRepDTO extends BaseRepDTO {

    /**
     * 业务订单号
     */
    private String          bizOrderNo;

    /**
     * 订单状态
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
