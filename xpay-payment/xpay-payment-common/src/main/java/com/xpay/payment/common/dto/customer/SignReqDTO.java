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
 * @version $Id: SignReqDTO.java, v 0.1 16/9/6 下午4:01 sxfans Exp $
 */
public class SignReqDTO extends BaseReqDTO {

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 卡类型
     */
    private EnumCardType cardType;

    /**
     * 手机号
     */
    private String mobileNo;

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
     * 签约请求号
     */
    private String signOrderNo;

    /**
     * 订单创建时间
     */
    private Date createDT;

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
     * Getter method for property signOrderNo.
     *
     * @return property value of signOrderNo
     **/
    public String getSignOrderNo() {
        return signOrderNo;
    }

    /**
     * Setter method for property signOrderNo.
     *
     * @param signOrderNo value to be assigned to property signOrderNo
     **/
    public void setSignOrderNo(String signOrderNo) {
        this.signOrderNo = signOrderNo;
    }

    /**
     * Getter method for property createDT.
     *
     * @return property value of createDT
     **/
    public Date getCreateDT() {
        return createDT;
    }

    /**
     * Setter method for property createDT.
     *
     * @param createDT value to be assigned to property createDT
     **/
    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }

}