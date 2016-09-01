/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.customer;

import com.xpay.common.enums.EnumRtnStatus;
import com.xpay.payment.common.dto.BaseRepDTO;

/**
 * @author qinshou
 * @version $Id: AuthRealNameRepDTO.java, v 0.1 16/8/6 下午11:31 sxfans Exp $
 */
public class AuthRealNameRepDTO extends BaseRepDTO {

    /**
     * 状态
     */
    private EnumRtnStatus realNameStatus;

    /**
     * Getter method for property realNameStatus.
     *
     * @return property value of realNameStatus
     **/
    public EnumRtnStatus getRealNameStatus() {
        return realNameStatus;
    }

    /**
     * Setter method for property realNameStatus.
     *
     * @param realNameStatus value to be assigned to property realNameStatus
     **/
    public void setRealNameStatus(EnumRtnStatus realNameStatus) {
        this.realNameStatus = realNameStatus;
    }
}