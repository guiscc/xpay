package com.xpay.trade.service.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易持久化实体
 * Created by sxfans on 16/8/13.
 */
public class TradeEntity {

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
    private short bizType;

    /**
     * 业务子类型
     */
    private short bizSubType;

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
    private short tradeStatus;

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

    public short getBizType() {
        return bizType;
    }

    public void setBizType(short bizType) {
        this.bizType = bizType;
    }

    public short getBizSubType() {
        return bizSubType;
    }

    public void setBizSubType(short bizSubType) {
        this.bizSubType = bizSubType;
    }

    public void setTradeStatus(short tradeStatus) {
        this.tradeStatus = tradeStatus;
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

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
