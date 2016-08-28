package com.xpay.trade.common.vo;

import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeReqVO extends BaseReqVO {

    /**
     * 业务订单号
     */
    private String bizOrderNo;

    /**
     * 业务类型
     */
    private EnumTradeType tradeType;

    /**
     * 业务子类型
     */
    private EnumTradeSubType tradeSubType;

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
     * 商品名称
     */
    private String goodsName;

    /**
     * 订单状态
     */
    private EnumTradeStatus tradeStatus;

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
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

    public EnumTradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(EnumTradeType tradeType) {
        this.tradeType = tradeType;
    }

    public EnumTradeSubType getTradeSubType() {
        return tradeSubType;
    }

    public void setTradeSubType(EnumTradeSubType tradeSubType) {
        this.tradeSubType = tradeSubType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public EnumTradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(EnumTradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
}
