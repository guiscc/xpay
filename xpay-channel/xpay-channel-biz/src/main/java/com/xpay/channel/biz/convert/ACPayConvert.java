/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import com.xpay.channel.common.dto.agentcollect.ACPayReqChannelDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.dto.PayOrderDTO;
import com.xpay.channel.common.dto.agentcollect.ACPayRepChannelDTO;
import com.xpay.channel.common.model.PayOrderModel;
import com.xpay.channel.common.vo.agentcollect.ACPayRepVO;
import com.xpay.channel.common.vo.agentcollect.ACPayReqVO;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: ACPayConvert.java, v 0.1 16/9/10 下午4:56 sxfans Exp $
 */
public class ACPayConvert {

    private static final Logger logger = LoggerFactory.getLogger(ACPayConvert.class);

    /**
     *
     * @param acPayReqFrontDTO
     * @param acPayReqVO
     * @return
     */
    public static ACPayReqFrontDTO getACPayReqFrontDTO(ACPayReqFrontDTO acPayReqFrontDTO,
                                                       ACPayReqVO acPayReqVO) {
        acPayReqFrontDTO.setBankOrderNo(acPayReqVO.getBankOrderNo());
        acPayReqFrontDTO.setPayAmt(acPayReqVO.getPayAmt());
        acPayReqFrontDTO.setCardType(acPayReqVO.getCardType());
        acPayReqFrontDTO.setCardNo(acPayReqVO.getCardNo());
        acPayReqFrontDTO.setCvv2(acPayReqVO.getCvv2());
//      acPayReqFrontDTO.setChannelCode();
//        acPayReqFrontDTO.setChannelType(acPayReqVO);
        acPayReqFrontDTO.setCertType(acPayReqVO.getCertType());
        acPayReqFrontDTO.setCertNo(acPayReqVO.getCertNo());
        acPayReqFrontDTO.setReqDateTime(new Date());
        acPayReqFrontDTO.setExpiredDate(acPayReqVO.getExpireDate());
        acPayReqFrontDTO.setHolderName(acPayReqVO.getHolderName());
        acPayReqFrontDTO.setMobileNo(acPayReqVO.getMobileNo());
        return acPayReqFrontDTO;
    }

    /**
     *
     * @param acPayRepVO
     * @param acPayRepFrontDTO
     * @return
     */
    public static ACPayRepVO getACPayRepFrontDTO(ACPayRepVO acPayRepVO,
                                                         ACPayRepFrontDTO acPayRepFrontDTO) {
        PayOrderModel payOrderModel = acPayRepVO.getPayOrderModel();
        if(payOrderModel == null){
            payOrderModel = new PayOrderModel();
        }

        payOrderModel.setPayStatus(acPayRepFrontDTO.getPayStatus());
        payOrderModel.setBankNo(acPayRepFrontDTO.getBankNo());
        payOrderModel.setPayAmt(acPayRepFrontDTO.getPayAmt());
        payOrderModel.setBankOrderNo(acPayRepFrontDTO.getBankOrderNo());
        payOrderModel.setRtnCode(acPayRepFrontDTO.getBankRtnCode());
        payOrderModel.setRtnMsg(acPayRepFrontDTO.getBankRtnMsg());
        return acPayRepVO;
    }

    /**
     * 获取变量
     *
     * @param acPayReqVO
     * @param acPayReqDTO
     * @return
     */
    public static ACPayReqVO getACPayReqVO(ACPayReqVO acPayReqVO, ACPayReqChannelDTO acPayReqDTO) {
        logger.info("请求模型:{}", acPayReqDTO);
        acPayReqVO.setUserId(acPayReqDTO.getUserId());
        acPayReqVO.setPayAmt(acPayReqDTO.getAmount());
        acPayReqVO.setCardType(acPayReqDTO.getCardType());
        acPayReqVO.setCardNo(acPayReqDTO.getCardNo());
        acPayReqVO.setHolderName(acPayReqDTO.getHolderName());
        acPayReqVO.setMobileNo(acPayReqDTO.getMobileNo());
        acPayReqVO.setCertType(acPayReqDTO.getCertType());
        acPayReqVO.setCvv2(acPayReqDTO.getCvv2());
        acPayReqVO.setExpireDate(acPayReqDTO.getExpireDate());
        acPayReqVO.setCreateDate(acPayReqDTO.getCreateDate());
        logger.info("转换请求模型:{}", acPayReqVO);
        return acPayReqVO;
    }

    /**
     * @param acPayRepDTO
     * @param acPayRepVO
     * @return
     */
    public static ACPayRepChannelDTO getACPayRepDTO(ACPayRepChannelDTO acPayRepDTO,
                                                    ACPayRepVO acPayRepVO) {
        logger.info("响应模型:{}", acPayRepVO);
        PayOrderDTO payOrderDTO = acPayRepDTO.getPayOrderDTO();
        PayOrderModel payOrderModel = acPayRepVO.getPayOrderModel();
        if (payOrderModel != null) {
            payOrderDTO.setTradeOrderNo(payOrderModel.getPayOrderNo());
            payOrderDTO.setPayOrderNo(payOrderModel.getPayOrderNo());
            payOrderDTO.setPayStatus(payOrderModel.getPayStatus());
            payOrderDTO.setPayAmt(payOrderModel.getPayAmt());
        }
        logger.info("转换响应模型:{}", acPayRepDTO);
        return acPayRepDTO;
    }

    /**
     * @param payOrderModel
     * @param acPayReqVO
     * @return
     */
    public static PayOrderModel getPayOrderModel(PayOrderModel payOrderModel, ACPayReqVO acPayReqVO) {
        payOrderModel.setPayTool(acPayReqVO.getPayTool());
        payOrderModel.setPaySubTool(acPayReqVO.getPaySubTool());
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