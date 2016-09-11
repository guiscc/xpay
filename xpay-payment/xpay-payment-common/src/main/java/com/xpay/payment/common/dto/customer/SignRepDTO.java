/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.customer;

import com.xpay.common.enums.EnumRtnStatus;
import com.xpay.payment.common.dto.BaseRepDTO;

/**
 * @author qinshou
 * @version $Id: SignRepDTO.java, v 0.1 16/9/6 下午4:03 sxfans Exp $
 */
public class SignRepDTO extends BaseRepDTO {

    /**
     * 状态
     */
    private EnumRtnStatus signStatus;

    /**
     * 签约号
     */
    private String signNo;

    /**
     * Getter method for property signStatus.
     *
     * @return property value of signStatus
     **/
    public EnumRtnStatus getSignStatus() {
        return signStatus;
    }

    /**
     * Setter method for property signStatus.
     *
     * @param signStatus value to be assigned to property signStatus
     **/
    public void setSignStatus(EnumRtnStatus signStatus) {
        this.signStatus = signStatus;
    }

    /**
     * Getter method for property signNo.
     *
     * @return property value of signNo
     **/
    public String getSignNo() {
        return signNo;
    }

    /**
     * Setter method for property signNo.
     *
     * @param signNo value to be assigned to property signNo
     **/
    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }
}