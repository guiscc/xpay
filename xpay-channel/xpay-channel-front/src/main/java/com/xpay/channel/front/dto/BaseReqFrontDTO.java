/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto;

import com.xpay.channel.common.enums.EnumExtMapKey;
import com.xpay.common.enums.EnumChannelType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinshou
 * @version $Id: BaseReqFrontDTO.java, v 0.1 16/10/18 下午2:53 sxfans Exp $
 */
public class BaseReqFrontDTO {

    private Map<String, String> headMap;

    private Date                reqDateTime;

    private Map<EnumExtMapKey, String> extMap =new HashMap<EnumExtMapKey,String>();

    private EnumChannelType channelType;

    private String channelCode;

    /**
     * Getter method for property channelCode.
     *
     * @return property value of channelCode
     **/
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * Setter method for property channelCode.
     *
     * @param channelCode value to be assigned to property channelCode
     **/
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * Getter method for property channelType.
     *
     * @return property value of channelType
     **/
    public EnumChannelType getChannelType() {
        return channelType;
    }

    /**
     * Setter method for property channelType.
     *
     * @param channelType value to be assigned to property channelType
     **/
    public void setChannelType(EnumChannelType channelType) {
        this.channelType = channelType;
    }

    /**
     * Getter method for property headMap.
     *
     * @return property value of headMap
     **/
    public Map<String, String> getHeadMap() {
        return headMap;
    }

    /**
     * Setter method for property headMap.
     *
     * @param headMap value to be assigned to property headMap
     **/
    public void setHeadMap(Map<String, String> headMap) {
        this.headMap = headMap;
    }

    /**
     * Getter method for property reqDateTime.
     *
     * @return property value of reqDateTime
     **/
    public Date getReqDateTime() {
        return reqDateTime;
    }

    /**
     * Setter method for property reqDateTime.
     *
     * @param reqDateTime value to be assigned to property reqDateTime
     **/
    public void setReqDateTime(Date reqDateTime) {
        this.reqDateTime = reqDateTime;
    }

    /**
     * Getter method for property extMap.
     *
     * @return property value of extMap
     **/
    public Map<EnumExtMapKey, String> getExtMap() {
        return extMap;
    }

    /**
     * Setter method for property extMap.
     *
     * @param extMap value to be assigned to property extMap
     **/
    public void setExtMap(Map<EnumExtMapKey, String> extMap) {
        this.extMap = extMap;
    }
}