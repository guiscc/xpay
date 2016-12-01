/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: PayToolsMappingEntity.java, v 0.1 16/11/30 上午11:44 sxfans Exp $
 */
public class PayToolsMappingEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     *
     */
    private String payToolsBankCode;

    /**
     * 通道id
     */
    private Long paySubToolCode;

    /**
     * 接口id
     */
    private Long channelCode;

    /**
     * 通道权重
     */
    private Integer channelWeight;

    /**
     * 通道费率
     */
    private Double channelRate;

    /**
     * 创建人
     */
    private String createPersion;

    /**
     * 更新人
     */
    private String updatePersion;

    /**
     * 创建时间
     */
    private Date createDT;

    /**
     * 更新时间
     */
    private Date updateDT;

    /**
     *
     */
    private String mappStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayToolsBankCode() {
        return payToolsBankCode;
    }

    public void setPayToolsBankCode(String payToolsBankCode) {
        this.payToolsBankCode = payToolsBankCode;
    }

    public Long getPaySubToolCode() {
        return paySubToolCode;
    }

    public void setPaySubToolCode(Long paySubToolCode) {
        this.paySubToolCode = paySubToolCode;
    }

    public Long getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(Long channelCode) {
        this.channelCode = channelCode;
    }

    public Integer getChannelWeight() {
        return channelWeight;
    }

    public void setChannelWeight(Integer channelWeight) {
        this.channelWeight = channelWeight;
    }

    public Double getChannelRate() {
        return channelRate;
    }

    public void setChannelRate(Double channelRate) {
        this.channelRate = channelRate;
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

    public Date getCreateDT() {
        return createDT;
    }

    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }

    public Date getUpdateDT() {
        return updateDT;
    }

    public void setUpdateDT(Date updateDT) {
        this.updateDT = updateDT;
    }

    public String getMappStatus() {
        return mappStatus;
    }

    public void setMappStatus(String mappstatus) {
        this.mappStatus = mappstatus == null ? null : mappstatus.trim();
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}