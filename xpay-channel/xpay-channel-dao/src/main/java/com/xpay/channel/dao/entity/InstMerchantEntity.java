/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: InstMerchantEntity.java, v 0.1 16/11/30 上午11:40 sxfans Exp $
 */
public class InstMerchantEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 机构编码
     */
    private String instCode;

    /**
     * 业务线编码
     */
    private String bizCode;

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 商户日限额
     */
    private Double merchantDayLimit;

    /**
     * 商户单笔
     */
    private Double merchantSingleLimit;

    /**
     * 商户月累计
     */
    private Double merchantMonthLimit;

    /**
     * 商户状态
     */
    private Byte merchantStatus;

    /**
     * 主密钥
     */
    private String cfgZmk;

    /**
     * 会话密钥
     */
    private String cfgZpk;

    /**
     * 签名密钥
     */
    private String cfgZak;

    /**
     * 密钥库路径
     */
    private String cfgPfxPath;

    /**
     * 证书路径
     */
    private String cfgCerPath;

    /**
     * 证书过期时间
     */
    private Date cfgCerOutDate;

    /**
     * 启用状态
     */
    private Byte cfgStatus;

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
     * 操作员
     */
    private String operatorCode;

    /**
     * 操作密码
     */
    private String operatorPwd;

    /**
     * 备注
     */
    private String mapstr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Double getMerchantDayLimit() {
        return merchantDayLimit;
    }

    public void setMerchantDayLimit(Double merchantDayLimit) {
        this.merchantDayLimit = merchantDayLimit;
    }

    public Double getMerchantSingleLimit() {
        return merchantSingleLimit;
    }

    public void setMerchantSingleLimit(Double merchantSingleLimit) {
        this.merchantSingleLimit = merchantSingleLimit;
    }

    public Double getMerchantMonthLimit() {
        return merchantMonthLimit;
    }

    public void setMerchantMonthLimit(Double merchantMonthLimit) {
        this.merchantMonthLimit = merchantMonthLimit;
    }

    public Byte getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(Byte merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getCfgZmk() {
        return cfgZmk;
    }

    public void setCfgZmk(String cfgZmk) {
        this.cfgZmk = cfgZmk;
    }

    public String getCfgZpk() {
        return cfgZpk;
    }

    public void setCfgZpk(String cfgZpk) {
        this.cfgZpk = cfgZpk;
    }

    public String getCfgZak() {
        return cfgZak;
    }

    public void setCfgZak(String cfgZak) {
        this.cfgZak = cfgZak;
    }

    public String getCfgPfxPath() {
        return cfgPfxPath;
    }

    public void setCfgPfxPath(String cfgPfxPath) {
        this.cfgPfxPath = cfgPfxPath;
    }

    public String getCfgCerPath() {
        return cfgCerPath;
    }

    public void setCfgCerPath(String cfgCerPath) {
        this.cfgCerPath = cfgCerPath;
    }

    public Date getCfgCerOutDate() {
        return cfgCerOutDate;
    }

    public void setCfgCerOutDate(Date cfgCerOutDate) {
        this.cfgCerOutDate = cfgCerOutDate;
    }

    public Byte getCfgStatus() {
        return cfgStatus;
    }

    public void setCfgStatus(Byte cfgStatus) {
        this.cfgStatus = cfgStatus;
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

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorPwd() {
        return operatorPwd;
    }

    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public String getMapstr() {
        return mapstr;
    }

    public void setMapstr(String mapstr) {
        this.mapstr = mapstr == null ? null : mapstr.trim();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}