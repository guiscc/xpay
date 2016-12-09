/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import com.xpay.channel.common.dto.ChannelOrderDTO;
import com.xpay.channel.common.dto.agentcollect.ACPayReqChannelDTO;
import com.xpay.channel.common.model.ChannelOrderModel;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.dto.agentcollect.ACPayRepChannelDTO;
import com.xpay.channel.common.vo.agentcollect.ACPayRepVO;
import com.xpay.channel.common.vo.agentcollect.ACPayReqVO;

import java.util.Date;

/**
 * 代付协议转换
 *
 * @author qinshou
 * @version $Id: ACPayConvert.java, v 0.1 16/9/10 下午4:56 sxfans Exp $
 */
public class ACPayConvert {

    private static final Logger logger = LoggerFactory.getLogger(ACPayConvert.class);

    /**
     * VO转前置DTO
     * @param acPayReqFrontDTO
     * @param acPayReqVO
     * @return
     */
    public static ACPayReqFrontDTO getACPayReqFrontDTO(ACPayReqFrontDTO acPayReqFrontDTO,
                                                       ACPayReqVO acPayReqVO, ChannelOrderModel channelOrderModel, RouterContext routerContext) {
        acPayReqFrontDTO.setBankOrderNo(channelOrderModel.getBankOrderNo());
        acPayReqFrontDTO.setPayAmt(channelOrderModel.getPayAmt());
        acPayReqFrontDTO.setCardType(acPayReqVO.getCardType());
        acPayReqFrontDTO.setCardNo(acPayReqVO.getCardNo());
        acPayReqFrontDTO.setCvv2(acPayReqVO.getCvv2());
        acPayReqFrontDTO.setCertType(acPayReqVO.getCertType());
        acPayReqFrontDTO.setCertNo(acPayReqVO.getCertNo());
        acPayReqFrontDTO.setReqDateTime(new Date());
        acPayReqFrontDTO.setExpiredDate(acPayReqVO.getExpireDate());
        acPayReqFrontDTO.setHolderName(acPayReqVO.getHolderName());
        acPayReqFrontDTO.setMobileNo(acPayReqVO.getMobileNo());
        acPayReqFrontDTO.setChannelCode(routerContext.getChannelEntity().getChannelCode());
        acPayReqFrontDTO.setMerchantNo(routerContext.getInstMerchantEntity().getMerchantNo());
        return acPayReqFrontDTO;
    }

    /**
     * 前置DTO转VO
     * @param channelOrderModel
     * @param acPayRepFrontDTO
     * @return
     */
    public static ChannelOrderModel getACPayRepFrontDTO(ChannelOrderModel channelOrderModel,
                                                         ACPayRepFrontDTO acPayRepFrontDTO) {
        channelOrderModel.setPayStatus(acPayRepFrontDTO.getPayStatus());
        channelOrderModel.setBankNo(acPayRepFrontDTO.getBankNo());
        channelOrderModel.setPayAmt(acPayRepFrontDTO.getPayAmt());
        channelOrderModel.setBankOrderNo(acPayRepFrontDTO.getBankOrderNo());
        channelOrderModel.setRtnCode(acPayRepFrontDTO.getBankRtnCode());
        channelOrderModel.setRtnMsg(acPayRepFrontDTO.getBankRtnMsg());
        return channelOrderModel;
    }

    /****************************************************************/

    /**
     * 渠道DTO转VO
     * @param acPayReqVO
     * @param acPayReqDTO
     * @return
     */
    public static ACPayReqVO getACPayReqVO(ACPayReqVO acPayReqVO, ACPayReqChannelDTO acPayReqDTO) {
        logger.info("请求模型:{}", acPayReqDTO);
        acPayReqVO.setUserId(acPayReqDTO.getUserId());

        acPayReqVO.setCurrency(acPayReqDTO.getCurrency());
        acPayReqVO.setPayAmt(acPayReqDTO.getAmount());

        //卡信息
        acPayReqVO.setCardType(acPayReqDTO.getCardType());
        acPayReqVO.setCardNo(acPayReqDTO.getCardNo());
        acPayReqVO.setCvv2(acPayReqDTO.getCvv2());
        acPayReqVO.setExpireDate(acPayReqDTO.getExpireDate());

        acPayReqVO.setHolderName(acPayReqDTO.getHolderName());
        acPayReqVO.setMobileNo(acPayReqDTO.getMobileNo());
        acPayReqVO.setCertType(acPayReqDTO.getCertType());
        acPayReqVO.setCertNo(acPayReqDTO.getCertNo());

        acPayReqVO.setCreateDate(acPayReqDTO.getCreateDate());
        acPayReqVO.setPayTool(EnumPayTool.BANKCARD);
        acPayReqVO.setPaySubTool(EnumPaySubTool.AGENTCOLLECT);
        acPayReqVO.setPayOrderNo(acPayReqDTO.getPayOrderNo());
        acPayReqVO.setInstCode(acPayReqDTO.getInstCode());
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
        ChannelOrderDTO channelOrderDTO = acPayRepDTO.getChannelOrderDTO();
        ChannelOrderModel channelOrderModel = acPayRepVO.getChannelOrderModel();
        if (channelOrderModel != null) {
            channelOrderDTO.setBankOrderNo(channelOrderModel.getPayOrderNo());
            channelOrderDTO.setPayOrderNo(channelOrderModel.getPayOrderNo());
            channelOrderDTO.setPayStatus(channelOrderModel.getPayStatus());
            channelOrderDTO.setPayAmt(channelOrderModel.getPayAmt());
        }
        acPayRepDTO.setChannelOrderDTO(channelOrderDTO);
        logger.info("转换响应模型:{}", acPayRepDTO);
        return acPayRepDTO;
    }
}