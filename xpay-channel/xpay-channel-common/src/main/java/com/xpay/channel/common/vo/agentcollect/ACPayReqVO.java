/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.vo.agentcollect;

import java.math.BigDecimal;
import java.util.Date;

import com.xpay.common.enums.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACPayReqVO.java, v 0.1 16/8/7 下午10:57 sxfans Exp $
 */
public class ACPayReqVO {

    /**
     * 渠道
     */
    private String         channelCode;

    /**
     * 支付工具
     */
    private EnumPayTool    payTool;

    /**
     * 支付子工具
     */
    private EnumPaySubTool paySubTool;

    /**
     * 支付金额
     */
    private BigDecimal     payAmt;

    /**
     * 货币类型
     */
    private EnumCurrency   currency;

    /**
     * 用户id
     */
    private String         userId;

    /**
     * 备注
     */
    private String         remark;

    /**
     * 卡号
     */
    private String         cardNo;

    /**
     * 卡类型
     */
    private EnumCardType   cardType;

    /**
     * 证件号
     */
    private String         certNo;

    /**
     * 证件类型
     */
    private EnumCertType   certType;

    /**
     * 持卡人姓名
     */
    private String         holderName;

    /**
     * cvv2
     */
    private String         cvv2;

    /**
     * 有效期
     */
    private String         expireDate;

    /**
     * 手机号
     */
    private String         mobileNo;

    /**
     * 订单创建时间
     */
    private Date           createDate;

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

    /**
     * Getter method for property cardNo.
     *
     * @return property value of cardNo
     **/
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Setter method for property cardNo.
     *
     * @param cardNo value to be assigned to property cardNo
     **/
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Getter method for property cardType.
     *
     * @return property value of cardType
     **/
    public EnumCardType getCardType() {
        return cardType;
    }

    /**
     * Setter method for property cardType.
     *
     * @param cardType value to be assigned to property cardType
     **/
    public void setCardType(EnumCardType cardType) {
        this.cardType = cardType;
    }

    /**
     * Getter method for property certNo.
     *
     * @return property value of certNo
     **/
    public String getCertNo() {
        return certNo;
    }

    /**
     * Setter method for property certNo.
     *
     * @param certNo value to be assigned to property certNo
     **/
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * Getter method for property certType.
     *
     * @return property value of certType
     **/
    public EnumCertType getCertType() {
        return certType;
    }

    /**
     * Setter method for property certType.
     *
     * @param certType value to be assigned to property certType
     **/
    public void setCertType(EnumCertType certType) {
        this.certType = certType;
    }

    /**
     * Getter method for property holderName.
     *
     * @return property value of holderName
     **/
    public String getHolderName() {
        return holderName;
    }

    /**
     * Setter method for property holderName.
     *
     * @param holderName value to be assigned to property holderName
     **/
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * Getter method for property cvv2.
     *
     * @return property value of cvv2
     **/
    public String getCvv2() {
        return cvv2;
    }

    /**
     * Setter method for property cvv2.
     *
     * @param cvv2 value to be assigned to property cvv2
     **/
    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    /**
     * Getter method for property expireDate.
     *
     * @return property value of expireDate
     **/
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Setter method for property expireDate.
     *
     * @param expireDate value to be assigned to property expireDate
     **/
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Getter method for property mobileNo.
     *
     * @return property value of mobileNo
     **/
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Setter method for property mobileNo.
     *
     * @param mobileNo value to be assigned to property mobileNo
     **/
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Getter method for property createDate.
     *
     * @return property value of createDate
     **/
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Setter method for property createDate.
     *
     * @param createDate value to be assigned to property createDate
     **/
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}