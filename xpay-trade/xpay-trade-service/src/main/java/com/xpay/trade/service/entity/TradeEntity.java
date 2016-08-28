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
    private byte tradeType;

    /**
     * 业务子类型
     */
    private byte tradeSubType;

    /**
     * 业务方生成订单时间
     */
    private Date bizOrderTime;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 实际支付金额
     */
    private BigDecimal payAmt;

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
    private byte tradeStatus;

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

    public byte getTradeType() {
        return tradeType;
    }

    public void setTradeType(byte tradeType) {
        this.tradeType = tradeType;
    }

    public byte getTradeSubType() {
        return tradeSubType;
    }

    public void setTradeSubType(byte tradeSubType) {
        this.tradeSubType = tradeSubType;
    }

    public byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * Getter method for property bizOrderTime.
     *
     * @return property value of bizOrderTime
     **/
    public Date getBizOrderTime() {
        return bizOrderTime;
    }

    /**
     * Setter method for property bizOrderTime.
     *
     * @param bizOrderTime value to be assigned to property bizOrderTime
     **/
    public void setBizOrderTime(Date bizOrderTime) {
        this.bizOrderTime = bizOrderTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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
