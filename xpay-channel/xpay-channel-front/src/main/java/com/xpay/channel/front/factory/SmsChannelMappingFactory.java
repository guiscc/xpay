/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.factory;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.facade.SmsChannelFacade;
import com.xpay.common.enums.EnumRtnResult;

import java.util.Map;

/**
 * @author qinshou
 * @version $Id: SmsChannelMappingFactory.java, v 0.1 16/10/25 上午1:19 sxfans Exp $
 */
public class SmsChannelMappingFactory implements MappingFactory<SmsChannelFacade> {
    /**
     * 接口具体实现集合
     * key : 接口编码
     * val : 接口具体实现类
     */
    private Map<String, SmsChannelFacade> mappingMap;

    @Override
    public SmsChannelFacade getChannelBean(String interCode) throws VldException {
        SmsChannelFacade smsChannelFacade = mappingMap.get(interCode);
        if (null == smsChannelFacade) {
            throw new VldException(EnumRtnResult.E000000);
        }
        return smsChannelFacade;
    }

    /**
     * Getter method for property mappingMap.
     *
     * @return property value of mappingMap
     **/
    public Map<String, SmsChannelFacade> getMappingMap() {
        return mappingMap;
    }

    /**
     * Setter method for property mappingMap.
     *
     * @param mappingMap value to be assigned to property mappingMap
     **/
    public void setMappingMap(Map<String, SmsChannelFacade> mappingMap) {
        this.mappingMap = mappingMap;
    }
}