/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.masterdata;

import com.xpay.payment.common.dto.BaseRepDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: CardBinRepDTO.java, v 0.1 16/10/10 上午8:23 sxfans Exp $
 */
public class CardBinRepDTO extends BaseRepDTO {


    private String id = "";
    private String bankCode;
    private String orgName;
    private String orgCode;
    private String cardName;
    private int noLength;
    private String mainCardNo;
    private int binLength;
    private String binValue;
    private String cardType;
    private Date createdDate;
    private Date modifiedDate;
    private Date deleteFlag;

    /**
     * Getter method for property id.
     *
     * @return property value of id
     **/
    public String getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     **/
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property bankCode.
     *
     * @return property value of bankCode
     **/
    public String getBankCode() {
        return bankCode;
    }

    /**
     * Setter method for property bankCode.
     *
     * @param bankCode value to be assigned to property bankCode
     **/
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * Getter method for property orgName.
     *
     * @return property value of orgName
     **/
    public String getOrgName() {
        return orgName;
    }

    /**
     * Setter method for property orgName.
     *
     * @param orgName value to be assigned to property orgName
     **/
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * Getter method for property orgCode.
     *
     * @return property value of orgCode
     **/
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * Setter method for property orgCode.
     *
     * @param orgCode value to be assigned to property orgCode
     **/
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * Getter method for property cardName.
     *
     * @return property value of cardName
     **/
    public String getCardName() {
        return cardName;
    }

    /**
     * Setter method for property cardName.
     *
     * @param cardName value to be assigned to property cardName
     **/
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Getter method for property noLength.
     *
     * @return property value of noLength
     **/
    public int getNoLength() {
        return noLength;
    }

    /**
     * Setter method for property noLength.
     *
     * @param noLength value to be assigned to property noLength
     **/
    public void setNoLength(int noLength) {
        this.noLength = noLength;
    }

    /**
     * Getter method for property mainCardNo.
     *
     * @return property value of mainCardNo
     **/
    public String getMainCardNo() {
        return mainCardNo;
    }

    /**
     * Setter method for property mainCardNo.
     *
     * @param mainCardNo value to be assigned to property mainCardNo
     **/
    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo;
    }

    /**
     * Getter method for property binLength.
     *
     * @return property value of binLength
     **/
    public int getBinLength() {
        return binLength;
    }

    /**
     * Setter method for property binLength.
     *
     * @param binLength value to be assigned to property binLength
     **/
    public void setBinLength(int binLength) {
        this.binLength = binLength;
    }

    /**
     * Getter method for property binValue.
     *
     * @return property value of binValue
     **/
    public String getBinValue() {
        return binValue;
    }

    /**
     * Setter method for property binValue.
     *
     * @param binValue value to be assigned to property binValue
     **/
    public void setBinValue(String binValue) {
        this.binValue = binValue;
    }

    /**
     * Getter method for property cardType.
     *
     * @return property value of cardType
     **/
    public String getCardType() {
        return cardType;
    }

    /**
     * Setter method for property cardType.
     *
     * @param cardType value to be assigned to property cardType
     **/
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * Getter method for property createdDate.
     *
     * @return property value of createdDate
     **/
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Setter method for property createdDate.
     *
     * @param createdDate value to be assigned to property createdDate
     **/
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Getter method for property modifiedDate.
     *
     * @return property value of modifiedDate
     **/
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Setter method for property modifiedDate.
     *
     * @param modifiedDate value to be assigned to property modifiedDate
     **/
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Getter method for property deleteFlag.
     *
     * @return property value of deleteFlag
     **/
    public Date getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * Setter method for property deleteFlag.
     *
     * @param deleteFlag value to be assigned to property deleteFlag
     **/
    public void setDeleteFlag(Date deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}