/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.channel.sms;

import com.xpay.channel.front.facade.SmsChannelFacade;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.channel.front.tongxin.ChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.vld.ChannelValidateHandler;
import com.xpay.common.enums.EnumChannelType;

import java.util.Map;

/**
 * @author qinshou
 * @version $Id: SmsChannelFacadeImpl.java, v 0.1 16/10/24 下午5:12 sxfans Exp $
 */
public abstract class SmsChannelFacadeImpl implements SmsChannelFacade {

    /**
     * 配置
     */
    protected ThreadLocal<ChannelConfig>                 channelConfig = new ThreadLocal<ChannelConfig>();

    /**
     * 参数验证组件
     */
    private Map<EnumChannelType, ChannelValidateHandler> channelValidateHandler;

    /**
     * 通信组件
     */
    private ChannelTongXinHandler                        channelTongXinHandler;

    /**
     * 报文组件
     */
    private Map<EnumChannelType, ChannelMsgHandler>      channelMsgHandler;

    /**
     * Getter method for property channelValidateHandler.
     *
     * @return property value of channelValidateHandler
     **/
    public Map<EnumChannelType, ChannelValidateHandler> getChannelValidateHandler() {
        return channelValidateHandler;
    }

    /**
     * Setter method for property channelValidateHandler.
     *
     * @param channelValidateHandler value to be assigned to property channelValidateHandler
     **/
    public void setChannelValidateHandler(Map<EnumChannelType, ChannelValidateHandler> channelValidateHandler) {
        this.channelValidateHandler = channelValidateHandler;
    }

    /**
     * Getter method for property channelTongXinHandler.
     *
     * @return property value of channelTongXinHandler
     **/
    public ChannelTongXinHandler getChannelTongXinHandler() {
        return channelTongXinHandler;
    }

    /**
     * Setter method for property channelTongXinHandler.
     *
     * @param channelTongXinHandler value to be assigned to property channelTongXinHandler
     **/
    public void setChannelTongXinHandler(ChannelTongXinHandler channelTongXinHandler) {
        this.channelTongXinHandler = channelTongXinHandler;
    }

    /**
     * Getter method for property channelMsgHandler.
     *
     * @return property value of channelMsgHandler
     **/
    public Map<EnumChannelType, ChannelMsgHandler> getChannelMsgHandler() {
        return channelMsgHandler;
    }

    /**
     * Setter method for property channelMsgHandler.
     *
     * @param channelMsgHandler value to be assigned to property channelMsgHandler
     **/
    public void setChannelMsgHandler(Map<EnumChannelType, ChannelMsgHandler> channelMsgHandler) {
        this.channelMsgHandler = channelMsgHandler;
    }

    public ChannelConfig getChannelConfig() {
        return channelConfig.get();
    }

    public void setChannelConfig(ChannelConfig channelConfig) {
        this.channelConfig.set(channelConfig);
    }

}