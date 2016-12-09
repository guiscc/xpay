package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseRepChannelDTO;
import com.xpay.channel.common.dto.ChannelOrderDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Remark 扣款返回
 * @Author pangyiyang
 * @Date 16/5/21 下午3:34
 */
public class ACPayRepChannelDTO extends BaseRepChannelDTO {

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
