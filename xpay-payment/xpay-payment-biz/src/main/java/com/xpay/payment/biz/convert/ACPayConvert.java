/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.PayOrderDTO;
import com.xpay.payment.common.dto.agentcollect.ACPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACPayReqDTO;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.common.vo.agentcollect.ACPayRepVO;
import com.xpay.payment.common.vo.agentcollect.ACPayReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinshou
 * @version $Id: ACPayConvert.java, v 0.1 16/9/10 下午4:56 sxfans Exp $
 */
public class ACPayConvert {

    private static final Logger logger = LoggerFactory.getLogger(ACPayConvert.class);

    /**
     * 获取变量
     *
     * @param acPayReqVO
     * @param acPayReqDTO
     * @return
     */
    public static ACPayReqVO getACPayReqVO(ACPayReqVO acPayReqVO,
                                           ACPayReqDTO acPayReqDTO) {
        logger.info("请求模型:", acPayReqDTO);
        acPayReqVO.setTradeOrderNo(acPayReqDTO.getTradeOrderNo());
        acPayReqVO.setPayTool(acPayReqDTO.getPayTool());
        acPayReqVO.setPaySubTool(acPayReqDTO.getPaySubTool());
        acPayReqVO.setChannelCode(acPayReqDTO.getChannelCode());
        acPayReqVO.setPayAmt(acPayReqDTO.getPayAmt());
        acPayReqVO.setCurrency(acPayReqDTO.getCurrency());
        acPayReqVO.setUserId(acPayReqDTO.getUserId());
        acPayReqVO.setRemark(acPayReqDTO.getRemark());
        logger.info("转换请求模型:", acPayReqVO);
        return acPayReqVO;
    }

    /**
     * @param acPayRepDTO
     * @param acPayRepVO
     * @return
     */
    public static ACPayRepDTO getACPayRepDTO(ACPayRepDTO acPayRepDTO,
                                             ACPayRepVO acPayRepVO) {
        logger.info("响应模型:", acPayRepVO);
        PayOrderDTO payOrderDTO = acPayRepDTO.getPayOrderDTO();
        PayOrderModel payOrderModel = acPayRepVO.getPayOrderModel();
        if (payOrderModel != null) {
            payOrderDTO.setTradeOrderNo(payOrderModel.getTradeOrderNo());
            payOrderDTO.setPayOrderNo(payOrderModel.getPayOrderNo());
            payOrderDTO.setPayStatus(payOrderModel.getPayStatus());
            payOrderDTO.setPayAmt(payOrderModel.getPayAmt());
        }
        logger.info("转换响应模型:", acPayRepDTO);
        return acPayRepDTO;
    }

    /**
     * @param payOrderModel
     * @param acPayReqVO
     * @return
     */
    public static PayOrderModel getPayOrderModel(PayOrderModel payOrderModel, ACPayReqVO acPayReqVO) {
        payOrderModel.setTradeOrderNo(acPayReqVO.getTradeOrderNo());
        payOrderModel.setPayTool(acPayReqVO.getPayTool());
        payOrderModel.setPaySubTool(acPayReqVO.getPaySubTool());
        payOrderModel.setChannelCode(acPayReqVO.getChannelCode());
        payOrderModel.setPayAmt(acPayReqVO.getPayAmt());
        payOrderModel.setCurrency(acPayReqVO.getCurrency());
        payOrderModel.setUserId(acPayReqVO.getUserId());
        payOrderModel.setRemark(acPayReqVO.getRemark());
        return payOrderModel;
    }

    /**
     * @param acPayRepVO
     * @param payOrderModel
     * @return
     */
    public static ACPayRepVO getACPayRepVO(ACPayRepVO acPayRepVO, PayOrderModel payOrderModel) {
        acPayRepVO.setPayOrderModel(payOrderModel);
//        acPayRepVO.getPayOrderModel().setCurrency(payOrderModel.getCurrency());
//        acPayRepVO.getPayOrderModel().setPayOrderNo(payOrderModel.getPayOrderNo());
//        acPayRepVO.getPayOrderModel().setPayAmt(payOrderModel.getPayAmt());
//        acPayRepVO.getPayOrderModel().setPayStatus(payOrderModel.getPayStatus());
//        acPayRepVO.getPayOrderModel().setPayTool(payOrderModel.getPayTool());
//        acPayRepVO.getPayOrderModel().setPaySubTool(payOrderModel.getPaySubTool());
//
//        acPayRepVO.getPayOrderModel().setChannelCode(payOrderModel.getChannelCode());
//        acPayRepVO.getPayOrderModel().setTradeOrderNo(payOrderModel.getTradeOrderNo());
//        acPayRepVO.getPayOrderModel().setCreateTime(payOrderModel.getCreateTime());
//        acPayRepVO.getPayOrderModel().setUserId(payOrderModel.getUserId());
//        acPayRepVO.getPayOrderModel().setRemark(payOrderModel.getRemark());
//        acPayRepVO.getPayOrderModel().setUpdateTime(payOrderModel.getUpdateTime());
        return acPayRepVO;
    }
}