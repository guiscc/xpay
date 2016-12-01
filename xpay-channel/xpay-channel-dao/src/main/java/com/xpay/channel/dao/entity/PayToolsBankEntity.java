/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: PayToolsBankEntity.java, v 0.1 16/11/30 上午11:41 sxfans Exp $
 */
public class PayToolsBankEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 支付工具编码
     */
    private Byte payToolsCode;

    /**
     * 子支付工具编码
     */
    private Byte paySubToolsCode;

    /**
     *
     */
    private String instCode;

    /**
     * 支付工具状态
     */
    private Byte payToolStatus;

    /**
     * 支付工具货币类型
     */
    private Byte payToolCurrency;

    /**
     * 支付工具卡类型
     */
    private Byte payToolCardType;

    /**
     * 创建人
     */
    private String createPersion;

    /**
     *  更新人
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
    private String payToolsBankCode;

    /**
     *
     */
    private String payToolsBankDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getPayToolsCode() {
        return payToolsCode;
    }

    public void setPayToolsCode(Byte payToolsCode) {
        this.payToolsCode = payToolsCode;
    }

    public Byte getPaySubToolsCode() {
        return paySubToolsCode;
    }

    public void setPaySubToolsCode(Byte paySubToolsCode) {
        this.paySubToolsCode = paySubToolsCode;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public Byte getPayToolStatus() {
        return payToolStatus;
    }

    public void setPayToolStatus(Byte payToolStatus) {
        this.payToolStatus = payToolStatus;
    }

    public Byte getPayToolCurrency() {
        return payToolCurrency;
    }

    public void setPayToolCurrency(Byte payToolCurrency) {
        this.payToolCurrency = payToolCurrency;
    }

    public Byte getPayToolCardType() {
        return payToolCardType;
    }

    public void setPayToolCardType(Byte payToolCardType) {
        this.payToolCardType = payToolCardType;
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

    public String getPayToolsBankCode() {
        return payToolsBankCode;
    }

    public void setPayToolsBankCode(String payToolsBankCode) {
        this.payToolsBankCode = payToolsBankCode;
    }

    public String getPayToolsBankDesc() {
        return payToolsBankDesc;
    }

    public void setPayToolsBankDesc(String payToolsBankDesc) {
        this.payToolsBankDesc = payToolsBankDesc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}