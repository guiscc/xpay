package com.xpay.channel.common.dto;

import com.xpay.channel.common.enums.EnumExtMapKey;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BaseReqChannelDTO {

    private Map<EnumExtMapKey, String> extMap = new HashMap<>();

    private Date                       reqDateTime;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
