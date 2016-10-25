package com.xpay.channel.front.channel.agentcollect;


import com.xpay.channel.front.facade.AgentCollectChannelFacade;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.channel.front.tongxin.ChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.vld.ChannelValidateHandler;
import com.xpay.common.enums.EnumChannelType;

import java.util.Map;

/**
 * 此类通过模版模式，抽象实现quickPayChannel接口，
 * 并且通过注入的方式将组件注入到类中，方便业务实现类组件核心接口调用
 */
public abstract class AgentCollectChannelFacadeImpl implements AgentCollectChannelFacade {

    /**
     * 参数验证组件
     */
    private Map<EnumChannelType, ChannelValidateHandler> channelValidateHandler;

    /**
     * 通信组件
     */
    private ChannelTongXinHandler channelTongXinHandler;

    /**
     * 报文组件
     */
    private Map<EnumChannelType, ChannelMsgHandler> channelMsgHandler;

    protected ThreadLocal<ChannelConfig> channelConfig = new ThreadLocal<ChannelConfig>();

    public ChannelTongXinHandler getChannelTongXinHandler() {
        return channelTongXinHandler;
    }

    public void setChannelTongXinHandler(ChannelTongXinHandler channelTongXinHandler) {
        this.channelTongXinHandler = channelTongXinHandler;
    }

    public Map<EnumChannelType, ChannelMsgHandler> getChannelMsgHandler() {
        return channelMsgHandler;
    }

    public void setChannelMsgHandler(Map<EnumChannelType, ChannelMsgHandler> channelMsgHandler) {
        this.channelMsgHandler = channelMsgHandler;
    }

    public ChannelConfig getChannelConfig() {
        return channelConfig.get();
    }

    public void setChannelConfig(ChannelConfig channelConfig) {
        this.channelConfig.set(channelConfig);
    }

    public Map<EnumChannelType, ChannelValidateHandler> getChannelValidateHandler() {
        return channelValidateHandler;
    }

    public void setChannelValidateHandler(Map<EnumChannelType, ChannelValidateHandler> channelValidateHandler) {
        this.channelValidateHandler = channelValidateHandler;
    }
}
