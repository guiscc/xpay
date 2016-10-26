/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseRepChannelDTO;
import com.xpay.channel.common.dto.PayOrderDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: ACRepairRepChannelDTO.java, v 0.1 16/9/14 上午10:43 sxfans Exp $
 */
public class ACRepairRepChannelDTO extends BaseRepChannelDTO {

    /**
     * 支付订单号
     */
    private PayOrderDTO payOrderDTO = new PayOrderDTO();

    /**
     * Getter method for property payOrderDTO.
     *
     * @return property value of payOrderDTO
     **/
    public PayOrderDTO getPayOrderDTO() {
        return payOrderDTO;
    }

    /**
     * Setter method for property payOrderDTO.
     *
     * @param payOrderDTO value to be assigned to property payOrderDTO
     **/
    public void setPayOrderDTO(PayOrderDTO payOrderDTO) {
        this.payOrderDTO = payOrderDTO;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}