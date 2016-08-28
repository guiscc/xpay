package com.xpay.trade.common.dto;

import com.xpay.trade.common.enums.EnumTradeStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 收单返回bean
 * Created by sxfans on 16/8/12.
 */
public class TradeRepDTO extends BaseRepDTO {

    /**
     * 业务订单号
     */
    private String          bizOrderNo;

    /**
     * 交易订单号
     */
    private String          tradeOrderNo;

    /**
     * 订单状态
     */
    private EnumTradeStatus tradeStatus;

    /**
     * 金额
     */
    private BigDecimal      payAmt;

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    /**
     * Getter method for property tradeStatus.
     *
     * @return property value of tradeStatus
     **/
    public EnumTradeStatus getTradeStatus() {
        return tradeStatus;
    }

    /**
     * Setter method for property tradeStatus.
     *
     * @param tradeStatus value to be assigned to property tradeStatus
     **/
    public void setTradeStatus(EnumTradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * Getter method for property payAmt.
     *
     * @return property value of payAmt
     **/
    public BigDecimal getPayAmt() {
        return payAmt;
    }

    /**
     * Setter method for property payAmt.
     *
     * @param payAmt value to be assigned to property payAmt
     **/
    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
