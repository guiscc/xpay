/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.dto;

import java.util.Date;
import java.util.Map;

/**
 * @author qinshou
 * @version $Id: BaseReqDTO.java, v 0.1 16/10/18 下午2:53 sxfans Exp $
 */
public class BaseReqDTO {

    /**
     *
     */
    private Map<String, String> headMap;

    private Date                reqDateTime;


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
}