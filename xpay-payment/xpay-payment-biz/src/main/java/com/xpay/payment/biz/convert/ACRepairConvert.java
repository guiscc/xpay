/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.agentcollect.ACRepairRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACRepairReqDTO;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.common.vo.agentcollect.ACRepairRepVO;
import com.xpay.payment.common.vo.agentcollect.ACRepairReqVO;

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
    public static ACRepairRepDTO getACRepairRepDTO(ACRepairRepDTO acRepairRepDTO,
                                                   ACRepairRepVO acRepairRepVO) {
        PayOrderModel payOrderModel = acRepairRepVO.getPayOrderModel();
        if (payOrderModel != null) {
            acRepairRepDTO.getPayOrderDTO().setPayOrderNo(payOrderModel.getPayOrderNo());
            acRepairRepDTO.getPayOrderDTO().setPayStatus(payOrderModel.getPayStatus());
            acRepairRepDTO.getPayOrderDTO().setTradeOrderNo(payOrderModel.getTradeOrderNo());
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
                                                 ACRepairReqDTO acRepairReqDTO) {
        acRepairReqVO.setPayOrderNo(acRepairReqVO.getPayOrderNo());
        acRepairReqVO.setTradeOrderNo(acRepairReqVO.getTradeOrderNo());
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