/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import com.xpay.channel.front.dto.agentcollect.ACQueryPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayReqFrontDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.dto.ChannelOrderDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayReqChannelDTO;
import com.xpay.channel.common.model.ChannelOrderModel;
import com.xpay.channel.common.vo.agentcollect.ACQueryPayRepVO;
import com.xpay.channel.common.vo.agentcollect.ACQueryPayReqVO;

/**
 * 查询协议转换
 * @author qinshou
 * @version $Id: ACQueryPayConvert.java, v 0.1 16/9/10 下午4:56 sxfans Exp $
 */
public class ACQueryPayConvert {

    private static Logger logger = LoggerFactory.getLogger(ACQueryPayConvert.class);

    /**
     * VO转前置DTO
     * @param acQueryPayReqFrontDTO
     * @param
     * @return
     */
    public static ACQueryPayReqFrontDTO getACQueryPayReqFrontDTO(ACQueryPayReqFrontDTO acQueryPayReqFrontDTO,
                                                                 ACQueryPayRepVO acQueryPayRepVO) {
        acQueryPayReqFrontDTO.setBankOrderNo(acQueryPayRepVO.getChannelOrderModel().getBankOrderNo());
        acQueryPayReqFrontDTO.setPayOrderDT(acQueryPayRepVO.getChannelOrderModel().getFinishDT());
        acQueryPayReqFrontDTO.setChannelCode(acQueryPayRepVO.getChannelOrderModel().getChannelCode());
        acQueryPayReqFrontDTO.setMerchantNo(acQueryPayRepVO.getChannelOrderModel().getMerchantNo());
        return acQueryPayReqFrontDTO;
    }

    /**
     * 前置DTO转VO
     * @param acQueryPayRepFrontDTO
     * @param channelOrderModel
     * @return
     */
    public static ChannelOrderModel getACQueryPayRepVO(ChannelOrderModel channelOrderModel,
                                                     ACQueryPayRepFrontDTO acQueryPayRepFrontDTO) {
        channelOrderModel.setRtnCode(acQueryPayRepFrontDTO.getBankRtnCode());
        channelOrderModel.setRtnMsg(acQueryPayRepFrontDTO.getBankRtnMsg());
        channelOrderModel.setBankOrderNo(acQueryPayRepFrontDTO.getBankOrderNo());
        channelOrderModel.setBankFinishDT(acQueryPayRepFrontDTO.getBankFinishTime());
        channelOrderModel.setBankNo(acQueryPayRepFrontDTO.getBankNo());
        channelOrderModel.setPayStatus(acQueryPayRepFrontDTO.getPayStatus());
        channelOrderModel.setPayAmt(acQueryPayRepFrontDTO.getPayAmt());
        return channelOrderModel;
    }


    /**************************************************/


    /**
     * 渠道DTO转VO
     * @param acQueryPayReqVO
     * @param acQueryPayReqDTO
     * @return
     */
    public static ACQueryPayReqVO getACQueryPayReqVO(ACQueryPayReqVO acQueryPayReqVO,
                                                     ACQueryPayReqChannelDTO acQueryPayReqDTO) {
        logger.info("请求模型:{}", acQueryPayReqDTO);
        acQueryPayReqVO.setPayOrderNo(acQueryPayReqDTO.getPayOrderNo());
        acQueryPayReqVO.setRepair(acQueryPayReqDTO.getRepair());
        logger.info("转换请求模型:{}", acQueryPayReqVO.toString());
        return acQueryPayReqVO;
    }

    /**
     * VO转渠道DTO
     * @param acQueryPayRepDTO
     * @param acQueryPayRepVO
     * @return
     */
    public static ACQueryPayRepChannelDTO getACQueryPayRepDTO(ACQueryPayRepChannelDTO acQueryPayRepDTO,
                                                              ACQueryPayRepVO acQueryPayRepVO) {
        logger.info("响应模型:{}", acQueryPayRepVO.toString());
        ChannelOrderModel channelOrderModel = acQueryPayRepVO.getChannelOrderModel();
        if (acQueryPayRepVO.getChannelOrderModel() != null) {
            ChannelOrderDTO channelOrderDTO = new ChannelOrderDTO();
            channelOrderDTO.setPayOrderNo(channelOrderModel.getPayOrderNo());
            channelOrderDTO.setBankOrderNo(channelOrderModel.getBankOrderNo());
            channelOrderDTO.setPayAmt(channelOrderModel.getPayAmt());
            channelOrderDTO.setPayStatus(channelOrderModel.getPayStatus());
            channelOrderDTO.setPaySubTool(channelOrderModel.getPaySubTool());
            channelOrderDTO.setChannelCode(channelOrderModel.getChannelCode());
            channelOrderDTO.setCreateTime(channelOrderModel.getCreateTime());
            channelOrderDTO.setCurrency(channelOrderModel.getCurrency());
            channelOrderDTO.setUpdateTime(channelOrderModel.getUpdateTime());
            acQueryPayRepDTO.setChannelOrderDTO(channelOrderDTO);
        }
        logger.info("转换响应模型:{}", acQueryPayRepDTO.toString());
        return acQueryPayRepDTO;
    }
}