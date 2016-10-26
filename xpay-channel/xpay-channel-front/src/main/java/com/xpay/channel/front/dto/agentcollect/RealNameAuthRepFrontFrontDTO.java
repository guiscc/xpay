/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.agentcollect;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.common.enums.EnumRtnStatus;

/**
 * @author qinshou
 * @version $Id: RealNameAuthRepFrontFrontDTO.java, v 0.1 16/10/17 下午2:16 sxfans Exp $
 */
public class RealNameAuthRepFrontFrontDTO extends BaseRepFrontDTO {

    /**
     * 认证状态
     */
    private EnumRtnStatus authStatus;

    /**
     * Getter method for property authStatus.
     *
     * @return property value of authStatus
     **/
    public EnumRtnStatus getAuthStatus() {
        return authStatus;
    }

    /**
     * Setter method for property authStatus.
     *
     * @param authStatus value to be assigned to property authStatus
     **/
    public void setAuthStatus(EnumRtnStatus authStatus) {
        this.authStatus = authStatus;
    }
}