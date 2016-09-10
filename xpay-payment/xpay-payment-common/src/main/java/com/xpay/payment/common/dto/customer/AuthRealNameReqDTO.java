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
     * 手机号
     */
    private String mobileNo;

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
}