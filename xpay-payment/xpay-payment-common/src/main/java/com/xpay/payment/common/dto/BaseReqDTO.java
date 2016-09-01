/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: BaseReqDTO.java, v 0.1 16/8/31 下午4:58 sxfans Exp $
 */
public class BaseReqDTO implements Serializable {

    /**
     * 客户端请求时间
     */
    private Date reqClientDT;

    /**
     * Getter method for property reqClientDT.
     *
     * @return property value of reqClientDT
     **/
    public Date getReqClientDT() {
        return reqClientDT;
    }

    /**
     * Setter method for property reqClientDT.
     *
     * @param reqClientDT value to be assigned to property reqClientDT
     **/
    public void setReqClientDT(Date reqClientDT) {
        this.reqClientDT = reqClientDT;
    }
}