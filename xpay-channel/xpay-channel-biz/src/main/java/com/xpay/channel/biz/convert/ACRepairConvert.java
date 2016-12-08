/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import com.xpay.channel.common.dto.agentcollect.ACRepairRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACRepairReqChannelDTO;
import com.xpay.channel.common.model.PayOrderModel;
import com.xpay.channel.common.vo.agentcollect.ACRepairRepVO;
import com.xpay.channel.common.vo.agentcollect.ACRepairReqVO;

/**
 * @author qinshou
 * @version $Id: ACRepairConvert.java, v 0.1 16/9/14 下午1:01 sxfans Exp $
 */
public class ACRepairConvert {

    /**
     * @param acRepairRepDTO
     * @param acRepairRepVO
     * @return
     */
    public static ACRepairRepChannelDTO getACRepairRepDTO(ACRepairRepChannelDTO acRepairRepDTO,
                                                          ACRepairRepVO acRepairRepVO) {
        PayOrderModel payOrderModel = acRepairRepVO.getPayOrderModel();
        if (payOrderModel != null) {
            acRepairRepDTO.getPayOrderDTO().setPayOrderNo(payOrderModel.getPayOrderNo());
            acRepairRepDTO.getPayOrderDTO().setPayStatus(payOrderModel.getPayStatus());
            acRepairRepDTO.getPayOrderDTO().setBankOrderNo(payOrderModel.getBankOrderNo());
            acRepairRepDTO.getPayOrderDTO().setPayAmt(payOrderModel.getPayAmt());
        }
        return acRepairRepDTO;
    }

    /**
     * @param acRepairReqVO
     * @param acRepairReqDTO
     * @return
     */
    public static ACRepairReqVO getACRepairReqVO(ACRepairReqVO acRepairReqVO,
                                                 ACRepairReqChannelDTO acRepairReqDTO) {
        acRepairReqVO.setPayOrderNo(acRepairReqDTO.getPayOrderNo());
        acRepairReqVO.setTradeOrderNo(acRepairReqDTO.getBankOrderNo());
        return acRepairReqVO;
    }

    /**
     * @param acRepairRepVO
     * @param payOrderModel
     * @return
     */
    public static ACRepairRepVO getACRepairRepVO(ACRepairRepVO acRepairRepVO,
                                                 PayOrderModel payOrderModel) {
        acRepairRepVO.setPayOrderModel(payOrderModel);
        return acRepairRepVO;
    }
}