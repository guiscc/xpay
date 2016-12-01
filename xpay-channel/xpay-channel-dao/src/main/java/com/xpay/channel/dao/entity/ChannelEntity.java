/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: ChannelEntity.java, v 0.1 16/11/30 上午11:39 sxfans Exp $
 */
public class ChannelEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 通道编码: UNIONPAY_C_01
     */
    private String channelCode;

    /**
     * 通道名称:银联快捷借记卡
     */
    private String channelName;

    /**
     * 机构编码
     */
    private String instCode;

    /**
     * 接口状态
     */
    private Byte channelStatus;

    /**
     * 通道卡类型
     */
    private Byte channelCardType;

    /**
     * 通道类型：网关/快捷
     */
    private Byte channelType;

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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public Byte getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Byte channelStatus) {
        this.channelStatus = channelStatus;
    }

    public Byte getChannelCardType() {
        return channelCardType;
    }

    public void setChannelCardType(Byte channelCardType) {
        this.channelCardType = channelCardType;
    }

    public Byte getChannelType() {
        return channelType;
    }

    public void setChannelType(Byte channelType) {
        this.channelType = channelType;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}