/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.vo.agentcollect;

import com.xpay.channel.common.model.ChannelOrderModel;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACPayReqVO.java, v 0.1 16/8/7 下午10:57 sxfans Exp $
 */
public class ACPayRepVO {

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