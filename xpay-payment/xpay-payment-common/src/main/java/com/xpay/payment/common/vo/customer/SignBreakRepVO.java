/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.customer;

import com.xpay.payment.common.enums.EnumSignStatus;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SignBreakRepVO.java, v 0.1 16/9/6 下午4:25 sxfans Exp $
 */
public class SignBreakRepVO {

    /**
     * 签约号
     */
    private String signNo;

    /**
     * 解约号
     */
    private String breakSignNo;

    /**
     * 签约状态
     */
    private EnumSignStatus signStatus;

    /**
     * 解约时间
     */
    private Date breakSignDT;

    /**
     * Getter method for property breakSignDT.
     *
     * @return property value of breakSignDT
     **/
    public Date getBreakSignDT() {
        return breakSignDT;
    }

    /**
     * Setter method for property breakSignDT.
     *
     * @param breakSignDT value to be assigned to property breakSignDT
     **/
    public void setBreakSignDT(Date breakSignDT) {
        this.breakSignDT = breakSignDT;
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