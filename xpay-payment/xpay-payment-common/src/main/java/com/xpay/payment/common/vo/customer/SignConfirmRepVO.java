/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.customer;

import com.xpay.payment.common.enums.EnumSignStatus;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SignConfirmRepVO.java, v 0.1 16/9/10 下午1:56 sxfans Exp $
 */

public class SignConfirmRepVO {

    /**
     * 签约号
     */
    private String signNo;

    /**
     * 签约状态
     */
    private EnumSignStatus signStatus;

    /**
     * 签约完成时间
     */
    private Date signFinishDT;

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

    /**
     * Getter method for property signFinishDT.
     *
     * @return property value of signFinishDT
     **/
    public Date getSignFinishDT() {
        return signFinishDT;
    }

    /**
     * Setter method for property signFinishDT.
     *
     * @param signFinishDT value to be assigned to property signFinishDT
     **/
    public void setSignFinishDT(Date signFinishDT) {
        this.signFinishDT = signFinishDT;
    }
}