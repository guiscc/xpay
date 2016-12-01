/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: InstActEntity.java, v 0.1 16/11/30 上午11:39 sxfans Exp $
 */
public class InstActEntity {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private String actCode;

    /**
     *
     */
    private String actName;

    /**
     *
     */
    private Byte actType;

    /**
     *
     */
    private Byte actStatus;

    /**
     *
     */
    private String actDetail;

    /**
     *
     */
    private String createPersion;

    /**
     *
     */
    private String updatePersion;

    /**
     *
     */
    private Date createDT;

    /**
     *
     */
    private Date updateDT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public Byte getActType() {
        return actType;
    }

    public void setActType(Byte actType) {
        this.actType = actType;
    }

    public Byte getActStatus() {
        return actStatus;
    }

    public void setActStatus(Byte actStatus) {
        this.actStatus = actStatus;
    }

    public String getActDetail() {
        return actDetail;
    }

    public void setActDetail(String actDetail) {
        this.actDetail = actDetail;
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