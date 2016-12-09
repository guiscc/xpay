/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseRepChannelDTO;
import com.xpay.channel.common.dto.ChannelOrderDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACRepairRepChannelDTO.java, v 0.1 16/9/14 上午10:43 sxfans Exp $
 */
public class ACRepairRepChannelDTO extends BaseRepChannelDTO {

    /**
     * 支付订单号
     */
    private ChannelOrderDTO channelOrderDTO = new ChannelOrderDTO();

    /**
     * Getter method for property channelOrderDTO.
     *
     * @return property value of channelOrderDTO
     **/
    public ChannelOrderDTO getChannelOrderDTO() {
        return channelOrderDTO;
    }

    /**
     * Setter method for property channelOrderDTO.
     *
     * @param channelOrderDTO value to be assigned to property channelOrderDTO
     **/
    public void setChannelOrderDTO(ChannelOrderDTO channelOrderDTO) {
        this.channelOrderDTO = channelOrderDTO;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}