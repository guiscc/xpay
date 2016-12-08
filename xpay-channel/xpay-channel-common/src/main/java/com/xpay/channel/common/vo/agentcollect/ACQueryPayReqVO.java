/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.vo.agentcollect;

import com.xpay.common.enums.EnumChannelType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: ACQueryPayReqVO.java, v 0.1 16/9/10 下午4:46 sxfans Exp $
 */
public class ACQueryPayReqVO {

    /**
     * 渠道类型
     */
    private EnumChannelType channelType;

    /**
     *
     */
    private Date payOrderDT;

    /**
     *
     */
    private String channelCode;

    /**
     * 银行订单号
     */
    private String bankOrderNo;

    /**
     * 支付单号
     */
    private String payOrderNo;

    /**
     * 补单标志
     */
    private boolean repair;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * Getter method for property merchantNo.
     *
     * @return property value of merchantNo
     **/
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * Setter method for property merchantNo.
     *
     * @param merchantNo value to be assigned to property merchantNo
     **/
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * Getter method for property channelType.
     *
     * @return property value of channelType
     **/
    public EnumChannelType getChannelType() {
        return channelType;
    }

    /**
     * Setter method for property channelType.
     *
     * @param channelType value to be assigned to property channelType
     **/
    public void setChannelType(EnumChannelType channelType) {
        this.channelType = channelType;
    }

    /**
     * Getter method for property payOrderDT.
     *
     * @return property value of payOrderDT
     **/
    public Date getPayOrderDT() {
        return payOrderDT;
    }

    /**
     * Setter method for property payOrderDT.
     *
     * @param payOrderDT value to be assigned to property payOrderDT
     **/
    public void setPayOrderDT(Date payOrderDT) {
        this.payOrderDT = payOrderDT;
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
     * Getter method for property bankOrderNo.
     *
     * @return property value of bankOrderNo
     **/
    public String getBankOrderNo() {
        return bankOrderNo;
    }

    /**
     * Setter method for property bankOrderNo.
     *
     * @param bankOrderNo value to be assigned to property bankOrderNo
     **/
    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo;
    }

    /**
     * Getter method for property payOrderNo.
     *
     * @return property value of payOrderNo
     **/
    public String getPayOrderNo() {
        return payOrderNo;
    }

    /**
     * Setter method for property payOrderNo.
     *
     * @param payOrderNo value to be assigned to property payOrderNo
     **/
    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    /**
     * Getter method for property repair.
     *
     * @return property value of repair
     **/
    public boolean getRepair() {
        return repair;
    }

    /**
     * Setter method for property repair.
     *
     * @param repair value to be assigned to property repair
     **/
    public void setRepair(boolean repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}