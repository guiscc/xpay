/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;

import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;

import java.math.BigDecimal;

/**
 * @author qinshou
 * @version $Id: RouterParam.java, v 0.1 16/12/1 上午11:49 sxfans Exp $
 */
public class RouterParam {

    /**
     * 支付工具
     */
    private EnumPayTool payTools;

    /**
     * 支付子工具
     */
    private EnumPaySubTool paySubTools;

    /**
     * 机构编码
     */
    private String instCode;

    /**
     * 支付金额
     */
    private BigDecimal payAmt;


    /**
     * Getter method for property payTools.
     *
     * @return property value of payTools
     **/
    public EnumPayTool getPayTools() {
        return payTools;
    }

    /**
     * Setter method for property payTools.
     *
     * @param payTools value to be assigned to property payTools
     **/
    public void setPayTools(EnumPayTool payTools) {
        this.payTools = payTools;
    }

    /**
     * Getter method for property paySubTools.
     *
     * @return property value of paySubTools
     **/
    public EnumPaySubTool getPaySubTools() {
        return paySubTools;
    }

    /**
     * Setter method for property paySubTools.
     *
     * @param paySubTools value to be assigned to property paySubTools
     **/
    public void setPaySubTools(EnumPaySubTool paySubTools) {
        this.paySubTools = paySubTools;
    }

    /**
     * Getter method for property instCode.
     *
     * @return property value of instCode
     **/
    public String getInstCode() {
        return instCode;
    }

    /**
     * Setter method for property instCode.
     *
     * @param instCode value to be assigned to property instCode
     **/
    public void setInstCode(String instCode) {
        this.instCode = instCode;
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
}