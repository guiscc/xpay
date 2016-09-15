/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.agentcollect;

import com.xpay.payment.common.dto.BaseRepDTO;
import com.xpay.payment.common.dto.PayOrderDTO;

/**
 * @author qinshou
 * @version $Id: ACPayRepDTO.java, v 0.1 16/7/31 上午11:08 sxfans Exp $
 */
public class ACPayRepDTO extends BaseRepDTO {

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
}