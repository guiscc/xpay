/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto;

import com.xpay.common.enums.EnumRtnResult;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: BaseRepDTO.java, v 0.1 16/8/31 下午4:59 sxfans Exp $
 */
public class BaseRepDTO implements Serializable {

    /**
     * 返回状态
     */
    private EnumRtnResult rtnResult;

    /**
     * 服务器时间
     */
    private Date serverDate;

    /**
     * Getter method for property rtnResult.
     *
     * @return property value of rtnResult
     **/
    public EnumRtnResult getRtnResult() {
        return rtnResult;
    }

    /**
     * Setter method for property rtnResult.
     *
     * @param rtnResult value to be assigned to property rtnResult
     **/
    public void setRtnResult(EnumRtnResult rtnResult) {
        this.rtnResult = rtnResult;
    }

    /**
     * Getter method for property serverDate.
     *
     * @return property value of serverDate
     **/
    public Date getServerDate() {
        return serverDate;
    }

    /**
     * Setter method for property serverDate.
     *
     * @param serverDate value to be assigned to property serverDate
     **/
    public void setServerDate(Date serverDate) {
        this.serverDate = serverDate;
    }
}