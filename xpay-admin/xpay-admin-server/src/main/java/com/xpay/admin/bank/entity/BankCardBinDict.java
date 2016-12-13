package com.xpay.admin.bank.entity;

import java.util.Date;

public class BankCardBinDict {
    private Long id;

    private String bankCode;

    private String orgName;

    private String orgCode;

    private String cardName;

    private Byte noLength;

    private String mainCardNo;

    private Byte binLength;

    private String binValue;

    private String cardType;

    private Date createdDate;

    private Date modifiedDate;

    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public Byte getNoLength() {
        return noLength;
    }

    public void setNoLength(Byte noLength) {
        this.noLength = noLength;
    }

    public String getMainCardNo() {
        return mainCardNo;
    }

    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo == null ? null : mainCardNo.trim();
    }

    public Byte getBinLength() {
        return binLength;
    }

    public void setBinLength(Byte binLength) {
        this.binLength = binLength;
    }

    public String getBinValue() {
        return binValue;
    }

    public void setBinValue(String binValue) {
        this.binValue = binValue == null ? null : binValue.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}