package com.xpay.payment.common.dto.agentcollect;

import com.xpay.common.enums.EnumCurrency;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import com.xpay.payment.common.dto.BaseRepDTO;
import com.xpay.payment.common.enums.EnumPayStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: AgentCollectReqDTO.java, v 0.1 16/7/31 上午11:09 sxfans Exp $
 */
public class AgentCollectReqDTO extends BaseRepDTO {

    /**
     * 交易单号
     */
    private String tradeOrderNo;

    /**
     * 支付工具
     */
    private EnumPayTool payTool;

    /**
     * 支付子工具
     */
    private EnumPaySubTool paySubTool;

    /**
     * 渠道
     */
    private String channelCode;

    /**
     * 支付金额
     */
    private BigDecimal payAmt;

    /**
     * 货币类型
     */
    private EnumCurrency currency;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 支付状态
     */
    private EnumPayStatus payStatus;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

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
     * Getter method for property payTool.
     *
     * @return property value of payTool
     **/
    public EnumPayTool getPayTool() {
        return payTool;
    }

    /**
     * Setter method for property payTool.
     *
     * @param payTool value to be assigned to property payTool
     **/
    public void setPayTool(EnumPayTool payTool) {
        this.payTool = payTool;
    }

    /**
     * Getter method for property paySubTool.
     *
     * @return property value of paySubTool
     **/
    public EnumPaySubTool getPaySubTool() {
        return paySubTool;
    }

    /**
     * Setter method for property paySubTool.
     *
     * @param paySubTool value to be assigned to property paySubTool
     **/
    public void setPaySubTool(EnumPaySubTool paySubTool) {
        this.paySubTool = paySubTool;
    }

    /**
     * Getter method for property channelCode.
     *
     * @return property value of channelCode
     **/
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * Setter method for property channelCode.
     *
     * @param channelCode value to be assigned to property channelCode
     **/
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
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
     * Getter method for property currency.
     *
     * @return property value of currency
     **/
    public EnumCurrency getCurrency() {
        return currency;
    }

    /**
     * Setter method for property currency.
     *
     * @param currency value to be assigned to property currency
     **/
    public void setCurrency(EnumCurrency currency) {
        this.currency = currency;
    }

    /**
     * Getter method for property userId.
     *
     * @return property value of userId
     **/
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property userId.
     *
     * @param userId value to be assigned to property userId
     **/
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property payStatus.
     *
     * @return property value of payStatus
     **/
    public EnumPayStatus getPayStatus() {
        return payStatus;
    }

    /**
     * Setter method for property payStatus.
     *
     * @param payStatus value to be assigned to property payStatus
     **/
    public void setPayStatus(EnumPayStatus payStatus) {
        this.payStatus = payStatus;
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
     * Getter method for property remark.
     *
     * @return property value of remark
     **/
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property remark.
     *
     * @param remark value to be assigned to property remark
     **/
    public void setRemark(String remark) {
        this.remark = remark;
    }
}