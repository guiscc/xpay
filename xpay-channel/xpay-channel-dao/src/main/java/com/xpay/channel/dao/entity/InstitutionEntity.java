/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: InstitutionEntity.java, v 0.1 16/11/30 上午11:40 sxfans Exp $
 */
public class InstitutionEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 机构编码
     */
    private String instCode;

    /**
     * 机构名称
     */
    private String instName;

    /**
     * 机构商户号
     */
    private Byte instFlag;

    /**
     * 机构省
     */
    private String instProvince;

    /**
     * 机构市
     */
    private String instCity;

    /**
     * 机构市
     */
    private String instArea;

    /**
     * 机构状态
     */
    private Byte instStatus;

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

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public Byte getInstFlag() {
        return instFlag;
    }

    public void setInstFlag(Byte instFlag) {
        this.instFlag = instFlag;
    }

    public String getInstProvince() {
        return instProvince;
    }

    public void setInstProvince(String instProvince) {
        this.instProvince = instProvince;
    }

    public String getInstCity() {
        return instCity;
    }

    public void setInstCity(String instCity) {
        this.instCity = instCity;
    }

    public String getInstArea() {
        return instArea;
    }

    public void setInstArea(String instArea) {
        this.instArea = instArea;
    }

    public Byte getInstStatus() {
        return instStatus;
    }

    public void setInstStatus(Byte instStatus) {
        this.instStatus = instStatus;
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