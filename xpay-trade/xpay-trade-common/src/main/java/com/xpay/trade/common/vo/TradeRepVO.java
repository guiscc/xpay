package com.xpay.trade.common.vo;

import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeRepVO extends BaseRepVO {
    /**
     * 主键
     */
    private long id;

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    /**
     * 交易单号
     */
    private String tradeOrderNo;

    /**
     * 业务类型
     */
    private EnumTradeType tradeTpye;

    /**
     * 业务子类型
     */
    private EnumTradeSubType tradeSubType;

    /**
     * 业务方生成订单时间
     */
    private Date orderTime;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 实际支付金额
     */
    private BigDecimal payAmount;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付单号
     */
    private String payNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private EnumTradeStatus tradeStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public EnumTradeType getTradeTpye() {
        return tradeTpye;
    }

    public void setTradeTpye(EnumTradeType tradeTpye) {
        this.tradeTpye = tradeTpye;
    }

    public EnumTradeSubType getTradeSubType() {
        return tradeSubType;
    }

    public void setTradeSubType(EnumTradeSubType tradeSubType) {
        this.tradeSubType = tradeSubType;
    }

    public EnumTradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(EnumTradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
