/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.vo.agentcollect;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.xpay.channel.common.model.ChannelOrderModel;


/**
 * @author qinshou
 * @version $Id: ACQueryPayRepVO.java, v 0.1 16/9/10 下午4:47 sxfans Exp $
 */
public class ACQueryPayRepVO {

    /**
     * 支付订单模型
     */
    private ChannelOrderModel channelOrderModel;

    /**
     * Getter method for property channelOrderModel.
     *
     * @return property value of channelOrderModel
     **/
    public ChannelOrderModel getChannelOrderModel() {
        return channelOrderModel;
    }

    /**
     * Setter method for property channelOrderModel.
     *
     * @param channelOrderModel value to be assigned to property channelOrderModel
     **/
    public void setChannelOrderModel(ChannelOrderModel channelOrderModel) {
        this.channelOrderModel = channelOrderModel;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}