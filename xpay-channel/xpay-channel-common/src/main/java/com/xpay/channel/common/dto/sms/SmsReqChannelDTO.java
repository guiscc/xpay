/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.sms;

import com.xpay.channel.common.dto.BaseReqChannelDTO;

/**
 * @author qinshou
 * @version $Id: SmsReqChannelDTO.java, v 0.1 16/10/26 上午11:06 sxfans Exp $
 */
public class SmsReqChannelDTO extends BaseReqChannelDTO {
    /**
     * 手机号码
     */
    private String mobileNo;

    private String userId;

    private String title;

    private String content;


    /**
     * Getter method for property mobileNo.
     *
     * @return property value of mobileNo
     **/
    public String getMobileNo() {
        return mobileNo;
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
}