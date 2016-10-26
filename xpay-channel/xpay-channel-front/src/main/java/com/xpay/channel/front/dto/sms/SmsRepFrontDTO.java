/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.sms;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.common.enums.EnumRtnStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: SmsRepFrontDTO.java, v 0.1 16/10/24 下午5:00 sxfans Exp $
 */
public class SmsRepFrontDTO extends BaseRepFrontDTO {

    /**
     * 发送状态
     */
    private EnumRtnStatus smsStatus;

    /**
     * Getter method for property smsStatus.
     *
     * @return property value of smsStatus
     **/
    public EnumRtnStatus getSmsStatus() {
        return smsStatus;
    }

    /**
     * Setter method for property smsStatus.
     *
     * @param smsStatus value to be assigned to property smsStatus
     **/
    public void setSmsStatus(EnumRtnStatus smsStatus) {
        this.smsStatus = smsStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}