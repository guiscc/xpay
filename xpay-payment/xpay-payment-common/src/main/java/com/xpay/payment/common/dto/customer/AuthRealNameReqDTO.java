/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.customer;

import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.payment.common.dto.BaseReqDTO;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: AuthRealNameReqDTO.java, v 0.1 16/8/6 下午11:32 sxfans Exp $
 */
public class AuthRealNameReqDTO extends BaseReqDTO {

    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 卡类型
     */
    private EnumCardType cardType;
    /**
     * 证件号
     */
    private String certNo;
    /**
     * 证件类型
     */
    private EnumCertType certType;
    /**
     * 持卡人姓名
     */
    private String holderName;
    /**
     * cvv2
     */
    private String cvv2;
    /**
     * 有效期
     */
    private String expireDate;
    /**
     * 渠道单号
     */
    private String channelOrderNo;
    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 订单创建时间
     */
    private Date channelCreateDate;

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
     * Getter method for property channelOrderNo.
     *
     * @return property value of channelOrderNo
     **/
    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    /**
     * Setter method for property channelOrderNo.
     *
     * @param channelOrderNo value to be assigned to property channelOrderNo
     **/
    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
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
     * Getter method for property channelCreateDate.
     *
     * @return property value of channelCreateDate
     **/
    public Date getChannelCreateDate() {
        return channelCreateDate;
    }

    /**
     * Setter method for property channelCreateDate.
     *
     * @param channelCreateDate value to be assigned to property channelCreateDate
     **/
    public void setChannelCreateDate(Date channelCreateDate) {
        this.channelCreateDate = channelCreateDate;
    }
}