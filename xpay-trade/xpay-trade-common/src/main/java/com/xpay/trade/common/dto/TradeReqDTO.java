package com.xpay.trade.common.dto;

import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeReqDTO extends BaseReqDTO {

    /**
     * 订单时间
     */
    private Date             bizOrderTime;

    /**
     * 业务订单号
     */
    private String           bizOrderNo;

    /**
     * 业务类型
     */
    private EnumTradeType    tradeType;

    /**
     * 子业务类型
     */
    private EnumTradeSubType tradeSubType;

    /**
     * 交易金额
     */
    private BigDecimal       payAmt;

    /**
     * 商品名称
     */
    private String           goodsName;

    /**
     * 订单过期时间
     */
    private Date           expireTime;

    /**
     * Getter method for property bizOrderNo.
     *
     * @return property value of bizOrderNo
     **/
    public String getBizOrderNo() {
        return bizOrderNo;
    }

    /**
     * Setter method for property bizOrderNo.
     *
     * @param bizOrderNo value to be assigned to property bizOrderNo
     **/
    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    /**
     * Getter method for property tradeType.
     *
     * @return property value of tradeType
     **/
    public EnumTradeType getTradeType() {
        return tradeType;
    }

    /**
     * Setter method for property tradeType.
     *
     * @param tradeType value to be assigned to property tradeType
     **/
    public void setTradeType(EnumTradeType tradeType) {
        this.tradeType = tradeType;
    }

    /**
     * Getter method for property tradeSubType.
     *
     * @return property value of tradeSubType
     **/
    public EnumTradeSubType getTradeSubType() {
        return tradeSubType;
    }

    /**
     * Setter method for property tradeSubType.
     *
     * @param tradeSubType value to be assigned to property tradeSubType
     **/
    public void setTradeSubType(EnumTradeSubType tradeSubType) {
        this.tradeSubType = tradeSubType;
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

    /**
     * Getter method for property goodsName.
     *
     * @return property value of goodsName
     **/
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * Setter method for property goodsName.
     *
     * @param goodsName value to be assigned to property goodsName
     **/
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    /**
     * Getter method for property expireTime.
     *
     * @return property value of expireTime
     **/
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * Setter method for property expireTime.
     *
     * @param expireTime value to be assigned to property expireTime
     **/
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
