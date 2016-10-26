/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto.sms;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.common.enums.EnumChannelType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: SmsReqFrontDTO.java, v 0.1 16/10/24 下午4:59 sxfans Exp $
 */
public class SmsReqFrontDTO extends BaseReqFrontDTO {

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 短信名称
     */
    private String title;

    /**
     * 用户ID
     */
    private String userId;

    {
        super.setChannelType(EnumChannelType.SMS);
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

    /**
     * Getter method for property mobileNo.
     *
     * @return property value of mobileNo
     **/
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Getter method for property title.
     *
     * @return property value of title
     **/
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property title.
     *
     * @param title value to be assigned to property title
     **/
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter method for property mobileNo.
     *
     * @param mobileNo value to be assigned to property mobileNo
     **/
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Getter method for property content.
     *
     * @return property value of content
     **/
    public String getContent() {
        return content;
    }

    /**
     * Setter method for property content.
     *
     * @param content value to be assigned to property content
     **/
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}