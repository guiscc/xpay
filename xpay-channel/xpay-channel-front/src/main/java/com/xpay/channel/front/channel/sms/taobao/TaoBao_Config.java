/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.channel.sms.taobao;

import com.xpay.channel.front.utils.ChannelConfig;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: TaoBao_Config.java, v 0.1 16/10/25 上午12:21 sxfans Exp $
 */
public class TaoBao_Config extends ChannelConfig {
    private String appKey;
    private String appSecret;
    private String template;
    private String normal;

    /**
     * Getter method for property appKey.
     *
     * @return property value of appKey
     **/
    public String getAppKey() {
        return appKey;
    }

    /**
     * Setter method for property appKey.
     *
     * @param appKey value to be assigned to property appKey
     **/
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * Getter method for property appSecret.
     *
     * @return property value of appSecret
     **/
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * Setter method for property appSecret.
     *
     * @param appSecret value to be assigned to property appSecret
     **/
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * Getter method for property template.
     *
     * @return property value of template
     **/
    public String getTemplate() {
        return template;
    }

    /**
     * Setter method for property template.
     *
     * @param template value to be assigned to property template
     **/
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Getter method for property normal.
     *
     * @return property value of normal
     **/
    public String getNormal() {
        return normal;
    }

    /**
     * Setter method for property normal.
     *
     * @param normal value to be assigned to property normal
     **/
    public void setNormal(String normal) {
        this.normal = normal;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}