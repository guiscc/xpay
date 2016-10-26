/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.customer;

import com.xpay.channel.common.dto.BaseRepChannelDTO;
import com.xpay.common.enums.EnumRtnStatus;

/**
 * @author qinshou
 * @version $Id: AuthRealNameRepChannelDTO.java, v 0.1 16/8/6 下午11:31 sxfans Exp $
 */
public class AuthRealNameRepChannelDTO extends BaseRepChannelDTO {

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