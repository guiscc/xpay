package com.xpay.trade.common.dto;

import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询结果返回
 * Created by sxfans on 16/8/12.
 */
public class QueryTradeRepDTO extends BaseRepDTO {
    /**
     * 主键
     */
    private long             id;

    /**
     * 业务订单号
     */
    private String           bizOrderNo;

    /**
     * 交易单号
     */
    private String           tradeOrderNo;

    /**
     * 业务类型
     */
    private EnumTradeType    tradeType;

    /**
     * 业务子类型
     */
    private EnumTradeSubType tradeSubType;

    /**
     * 业务方生成订单时间
     */
    private Date             orderTime;

    /**
     * 过期时间
     */
    private Date             expireTime;

    /**
     * 实际支付金额
     */
    private BigDecimal       payAmount;

    /**
     * 支付时间
     */
    private Date             payTime;

    /**
     * 支付单号
     */
    private String           payNo;

    /**
     * 创建时间
     */
    private Date             createTime;

    /**
     * 创建时间
     */
    private Date             updateTime;

    /**
     * 状态
     */
    private EnumTradeStatus  tradeStatus;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Getter method for property id.
     *
     * @return property value of id
     **/
    public long getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     **/
    public void setId(long id) {
        this.id = id;
    }

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
     * Getter method for property tradeOrderNo.
     *
     * @return property value of tradeOrderNo
     **/
    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    /**
     * Setter method for property tradeOrderNo.
     *
     * @param tradeOrderNo value to be assigned to property tradeOrderNo
     **/
    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
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
     * Getter method for property orderTime.
     *
     * @return property value of orderTime
     **/
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * Setter method for property orderTime.
     *
     * @param orderTime value to be assigned to property orderTime
     **/
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    /**
     * Getter method for property payAmount.
     *
     * @return property value of payAmount
     **/
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * Setter method for property payAmount.
     *
     * @param payAmount value to be assigned to property payAmount
     **/
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * Getter method for property payTime.
     *
     * @return property value of payTime
     **/
    public Date getPayTime() {
        return payTime;
    }

    /**
     * Setter method for property payTime.
     *
     * @param payTime value to be assigned to property payTime
     **/
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * Getter method for property payNo.
     *
     * @return property value of payNo
     **/
    public String getPayNo() {
        return payNo;
    }

    /**
     * Setter method for property payNo.
     *
     * @param payNo value to be assigned to property payNo
     **/
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * Getter method for property createTime.
     *
     * @return property value of createTime
     **/
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property createTime.
     *
     * @param createTime value to be assigned to property createTime
     **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property updateTime.
     *
     * @return property value of updateTime
     **/
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Setter method for property updateTime.
     *
     * @param updateTime value to be assigned to property updateTime
     **/
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}
