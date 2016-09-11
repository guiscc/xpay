/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.customer;

import com.xpay.payment.common.dto.BaseRepDTO;
import com.xpay.payment.common.enums.EnumSignStatus;

/**
 * @author qinshou
 * @version $Id: SignBreakRepDTO.java, v 0.1 16/9/6 下午4:20 sxfans Exp $
 */
public class SignBreakRepDTO extends BaseRepDTO {

    /**
     * 签约号
     */
    private String breakSignNo;

    /**
     * 签约状态
     */
    private EnumSignStatus signStatus;

    /**
     * Getter method for property breakSignNo.
     *
     * @return property value of breakSignNo
     **/
    public String getBreakSignNo() {
        return breakSignNo;
    }

    /**
     * Setter method for property breakSignNo.
     *
     * @param breakSignNo value to be assigned to property breakSignNo
     **/
    public void setBreakSignNo(String breakSignNo) {
        this.breakSignNo = breakSignNo;
    }

    /**
     * Getter method for property signStatus.
     *
     * @return property value of signStatus
     **/
    public EnumSignStatus getSignStatus() {
        return signStatus;
    }

    /**
     * Setter method for property signStatus.
     *
     * @param signStatus value to be assigned to property signStatus
     **/
    public void setSignStatus(EnumSignStatus signStatus) {
        this.signStatus = signStatus;
    }
}