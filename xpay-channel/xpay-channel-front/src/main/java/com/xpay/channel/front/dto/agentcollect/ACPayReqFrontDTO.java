/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.common.enums.EnumChannelType;

import java.math.BigDecimal;

/**
 * @author qinshou
 * @version $Id: ACPayReqFrontDTO.java, v 0.1 16/10/17 下午2:03 sxfans Exp $
 */
public class ACPayReqFrontDTO extends BaseReqFrontDTO {

    private String bankOrderNo;

    private BigDecimal payAmt;

    private EnumCardType cardType;

    private String cardNo;

    private String cvv2;

    private String expiredDate;

    private EnumCertType certType;

    private String certNo;

    private String holderName;

    private String mobileNo;



    {
        super.setChannelType(EnumChannelType.PAY);
    }

    /**
     * Getter method for property cardNo.
     *
     * @return property value of cardNo
     **/
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Setter method for property cardNo.
     *
     * @param cardNo value to be assigned to property cardNo
     **/
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Getter method for property cardType.
     *
     * @return property value of cardType
     **/
    public EnumCardType getCardType() {
        return cardType;
    }

    /**
     * Setter method for property cardType.
     *
     * @param cardType value to be assigned to property cardType
     **/
    public void setCardType(EnumCardType cardType) {
        this.cardType = cardType;
    }

    /**
     * Getter method for property certType.
     *
     * @return property value of certType
     **/
    public EnumCertType getCertType() {
        return certType;
    }

    /**
     * Setter method for property certType.
     *
     * @param certType value to be assigned to property certType
     **/
    public void setCertType(EnumCertType certType) {
        this.certType = certType;
    }

    /**
     * Getter method for property mobileNo.
     *
     * @return property value of mobileNo
     **/
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Setter method for property mobileNo.
     *
     * @param mobileNo value to be assigned to property mobileNo
     **/
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Getter method for property certNo.
     *
     * @return property value of certNo
     **/
    public String getCertNo() {
        return certNo;
    }

    /**
     * Setter method for property certNo.
     *
     * @param certNo value to be assigned to property certNo
     **/
    public void setCertNo(String certNo) {
        this.certNo = certNo;
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
     * Getter method for property payAmt.
     *
     * @return property value of payAmt
     **/
    public BigDecimal getPayAmt() {
        return payAmt;
    }

    /**
     * Setter method for property payAmt.
     *
     * @param payAmt value to be assigned to property payAmt
     **/
    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    /**
     * Getter method for property holderName.
     *
     * @return property value of holderName
     **/
    public String getHolderName() {
        return holderName;
    }

    /**
     * Getter method for property cvv2.
     *
     * @return property value of cvv2
     **/
    public String getCvv2() {
        return cvv2;
    }

    /**
     * Setter method for property cvv2.
     *
     * @param cvv2 value to be assigned to property cvv2
     **/
    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    /**
     * Getter method for property expiredDate.
     *
     * @return property value of expiredDate
     **/
    public String getExpiredDate() {
        return expiredDate;
    }

    /**
     * Setter method for property expiredDate.
     *
     * @param expiredDate value to be assigned to property expiredDate
     **/
    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    /**
     * Setter method for property holderName.
     *
     * @param holderName value to be assigned to property holderName
     **/
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}