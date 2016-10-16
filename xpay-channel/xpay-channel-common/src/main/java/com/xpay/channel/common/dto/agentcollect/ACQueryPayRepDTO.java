package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseRepDTO;
import com.xpay.channel.common.dto.PayOrderDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Remark 查询
 * @Author pangyiyang
 * @Date 16/5/22 下午4:26
 */
public class ACQueryPayRepDTO extends BaseRepDTO {

    /**
     * 支付单模型
     */
    private PayOrderDTO payOrderDTO;

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
