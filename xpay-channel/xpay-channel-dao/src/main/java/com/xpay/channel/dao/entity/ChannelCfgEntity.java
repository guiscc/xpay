/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: ChannelCfgEntity.java, v 0.1 16/11/30 上午11:36 sxfans Exp $
 */
public class ChannelCfgEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 通道编码
     */
    private String channelCode;

    /**
     * 后台回调地址
     */
    private String callBackUrl;

    /**
     * 前台回调地址
     */
    private String callPageUrl;

    /**
     * 退款回调地址
     */
    private String refundCallBackUrl;

    /**
     * 对账时间
     */
    private Date chkFileDT;

    /**
     * 对账类型
     */
    private Byte chkFileType;

    /**
     * 退款类型
     */
    private Byte refundType;

    /**
     * 订单号前缀
     */
    private String orderNoPrefix;

    /**
     * 订单号长度
     */
    private Integer orderNoLen;

    /**
     * 支付类型
     */
    private Byte payType;

    /**
     * 签约类型
     */
    private Byte signType;

    /**
     * 创建人
     */
    private String createPersion;

    /**
     * 更新人
     */
    private String updatePersion;

    /**
     * 更新时间
     */
    private Date updateDT;

    /**
     * 创建时间
     */
    private Date createDT;

    /**
     * 发短信方式
     */
    private Byte smsType;

    /**
     * 补单启用状态
     */
    private Byte repairStatus;

    /**
     * 补单周期
     */
    private Integer repairMinute;

    /**
     * 补单银行缓冲时间
     */
    private Long bankBufferMill;

    /**
     * 补单最大金额
     */
    private Double repairMaxAmt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getCallPageUrl() {
        return callPageUrl;
    }

    public void setCallPageUrl(String callPageUrl) {
        this.callPageUrl = callPageUrl;
    }

    public String getRefundCallBackUrl() {
        return refundCallBackUrl;
    }

    public void setRefundCallBackUrl(String refundCallBackUrl) {
        this.refundCallBackUrl = refundCallBackUrl;
    }

    public Date getChkFileDT() {
        return chkFileDT;
    }

    public void setChkFileDT(Date chkFileDT) {
        this.chkFileDT = chkFileDT;
    }

    public Byte getChkFileType() {
        return chkFileType;
    }

    public void setChkFileType(Byte chkFileType) {
        this.chkFileType = chkFileType;
    }

    public Byte getRefundType() {
        return refundType;
    }

    public void setRefundType(Byte refundType) {
        this.refundType = refundType;
    }

    public String getOrderNoPrefix() {
        return orderNoPrefix;
    }

    public void setOrderNoPrefix(String orderNoPrefix) {
        this.orderNoPrefix = orderNoPrefix;
    }

    public Integer getOrderNoLen() {
        return orderNoLen;
    }

    public void setOrderNoLen(Integer orderNoLen) {
        this.orderNoLen = orderNoLen;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getSignType() {
        return signType;
    }

    public void setSignType(Byte signType) {
        this.signType = signType;
    }

    public String getCreatePersion() {
        return createPersion;
    }

    public void setCreatePersion(String createPersion) {
        this.createPersion = createPersion;
    }

    public String getUpdatePersion() {
        return updatePersion;
    }

    public void setUpdatePersion(String updatePersion) {
        this.updatePersion = updatePersion;
    }

    public Date getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(Date updateDT) {
        this.updateDT = updateDT;
    }

    public Date getCreateDT() {
        return createDT;
    }

    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }

    public Byte getSmsType() {
        return smsType;
    }

    public void setSmsType(Byte smsType) {
        this.smsType = smsType;
    }

    public Byte getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Byte repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Integer getRepairMinute() {
        return repairMinute;
    }

    public void setRepairMinute(Integer repairMinute) {
        this.repairMinute = repairMinute;
    }

    public Long getBankBufferMill() {
        return bankBufferMill;
    }

    public void setBankBufferMill(Long bankBufferMill) {
        this.bankBufferMill = bankBufferMill;
    }

    public Double getRepairMaxAmt() {
        return repairMaxAmt;
    }

    public void setRepairMaxAmt(Double repairMaxAmt) {
        this.repairMaxAmt = repairMaxAmt;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}