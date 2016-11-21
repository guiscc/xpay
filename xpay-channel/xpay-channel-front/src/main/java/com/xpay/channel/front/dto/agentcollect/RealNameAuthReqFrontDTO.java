/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseReqFrontDTO;

/**
 * @author qinshou
 * @version $Id: RealNameAuthReqFrontDTO.java, v 0.1 16/10/17 下午2:16 sxfans Exp $
 */
public class RealNameAuthReqFrontDTO extends BaseReqFrontDTO {

    private String bankAuthrNo;

    private String cerNo;

    private String holderName;

    private String mobileNo;

    private String cardType;

    private String cardNo;

    private String cvv2;

    private String expireDate;

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
     * Getter method for property expireDate.
     *
     * @return property value of expireDate
     **/
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Setter method for property expireDate.
     *
     * @param expireDate value to be assigned to property expireDate
     **/
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
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
     * Getter method for property bankAuthrNo.
     *
     * @return property value of bankAuthrNo
     **/
    public String getBankAuthrNo() {
        return bankAuthrNo;
    }

    /**
     * Setter method for property bankAuthrNo.
     *
     * @param bankAuthrNo value to be assigned to property bankAuthrNo
     **/
    public void setBankAuthrNo(String bankAuthrNo) {
        this.bankAuthrNo = bankAuthrNo;
    }

    /**
     * Getter method for property cerNo.
     *
     * @return property value of cerNo
     **/
    public String getCerNo() {
        return cerNo;
    }

    /**
     * Setter method for property cerNo.
     *
     * @param cerNo value to be assigned to property cerNo
     **/
    public void setCerNo(String cerNo) {
        this.cerNo = cerNo;
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
     * Setter method for property holderName.
     *
     * @param holderName value to be assigned to property holderName
     **/
    public void setHolderName(String holderName) {
        this.holderName = holderName;
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
}