/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.sms;

import com.xpay.common.enums.EnumRtnStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: SmsRepChannelDTO.java, v 0.1 16/10/26 上午11:06 sxfans Exp $
 */
public class SmsRepChannelDTO {

    /**
     * 发送状态
     */
    private EnumRtnStatus smsStatus;

    private String userId;

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

    /**
     * Getter method for property userId.
     *
     * @return property value of userId
     **/
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property userId.
     *
     * @param userId value to be assigned to property userId
     **/
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}