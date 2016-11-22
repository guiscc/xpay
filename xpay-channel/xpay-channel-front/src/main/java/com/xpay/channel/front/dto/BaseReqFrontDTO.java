/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto;

import com.xpay.common.enums.EnumChannelType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinshou
 * @version $Id: BaseReqFrontDTO.java, v 0.1 16/10/18 下午2:53 sxfans Exp $
 */
public class BaseReqFrontDTO {

    /**
     * http通信使用的报文头
     */
    private Map<String, String> httpHeadMap;

    /**
     * form表单提交使用的全量参数
     */
    private Map<String, String> formMap;

    /**
     *
     */
    private Map<String, Object> fmkMap;

    /**
     * 请求时间
     */
    private Date                reqDateTime;

    /**
     * 渠道类型
     */
    private EnumChannelType     channelType;

    /**
     * 渠道编码
     */
    private String              channelCode;

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
     * Getter method for property httpHeadMap.
     *
     * @return property value of httpHeadMap
     **/
    public Map<String, String> getHttpHeadMap() {
        return httpHeadMap;
    }

    /**
     * Setter method for property httpHeadMap.
     *
     * @param httpHeadMap value to be assigned to property httpHeadMap
     **/
    public void setHttpHeadMap(Map<String, String> httpHeadMap) {
        this.httpHeadMap = httpHeadMap;
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
     * Getter method for property formMap.
     *
     * @return property value of formMap
     **/
    public Map<String, String> getFormMap() {
        return formMap;
    }

    /**
     * Setter method for property formMap.
     *
     * @param formMap value to be assigned to property formMap
     **/
    public void setFormMap(Map<String, String> formMap) {
        this.formMap = formMap;
    }

    /**
     * Getter method for property fmkMap.
     *
     * @return property value of fmkMap
     **/
    public Map<String, Object> getFmkMap() {
        return fmkMap;
    }

    /**
     * Setter method for property fmkMap.
     *
     * @param fmkMap value to be assigned to property fmkMap
     **/
    public void setFmkMap(Map<String, Object> fmkMap) {
        this.fmkMap = fmkMap;
    }
}