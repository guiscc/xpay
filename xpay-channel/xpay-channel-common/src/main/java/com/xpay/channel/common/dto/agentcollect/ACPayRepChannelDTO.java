package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseRepChannelDTO;
import com.xpay.channel.common.dto.PayOrderDTO;
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
