/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.dto.PayOrderDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayRepChannelDTO;
import com.xpay.channel.common.dto.agentcollect.ACQueryPayReqChannelDTO;
import com.xpay.channel.common.model.PayOrderModel;
import com.xpay.channel.common.vo.agentcollect.ACQueryPayRepVO;
import com.xpay.channel.common.vo.agentcollect.ACQueryPayReqVO;

/**
 * @author qinshou
 * @version $Id: ACQueryPayConvert.java, v 0.1 16/9/10 下午4:56 sxfans Exp $
 */
public class ACQueryPayConvert {

    private static Logger logger = LoggerFactory.getLogger(ACQueryPayConvert.class);

    /**
     * @param acQueryPayReqVO
     * @param acQueryPayReqDTO
     * @return
     */
    public static ACQueryPayReqVO getACQueryPayReqVO(ACQueryPayReqVO acQueryPayReqVO,
                                                     ACQueryPayReqChannelDTO acQueryPayReqDTO) {
        logger.info("请求模型:{}", acQueryPayReqDTO);
        acQueryPayReqVO.setPayOrderNo(acQueryPayReqDTO.getPayOrderNo());
        logger.info("转换请求模型:{}", acQueryPayReqVO.toString());
        return acQueryPayReqVO;
    }

    /**
     * @param acQueryPayRepDTO
     * @param acQueryPayRepVO
     * @return
     */
    public static ACQueryPayRepChannelDTO getACQueryPayRepDTO(ACQueryPayRepChannelDTO acQueryPayRepDTO,
                                                              ACQueryPayRepVO acQueryPayRepVO) {
        logger.info("响应模型:{}", acQueryPayRepVO.toString());
        PayOrderDTO payOrderDTO = acQueryPayRepDTO.getPayOrderDTO();
        PayOrderModel payOrderModel = acQueryPayRepVO.getPayOrderModel();
        if (acQueryPayRepVO.getPayOrderModel() != null) {
            payOrderDTO.setPayOrderNo(payOrderModel.getPayOrderNo());
            payOrderDTO.setTradeOrderNo(payOrderModel.getTradeOrderNo());
            payOrderDTO.setPayAmt(payOrderModel.getPayAmt());
            payOrderDTO.setPayStatus(payOrderModel.getPayStatus());
        }
        logger.info("转换响应模型:{}", acQueryPayRepDTO.toString());
        return acQueryPayRepDTO;
    }

    public static ACQueryPayRepVO getACQueryPayRepVO(ACQueryPayRepVO acQueryPayRepVO,
                                                     PayOrderModel payOrderModel) {
        logger.info("订单查询模型层转换:{}", acQueryPayRepVO);
        acQueryPayRepVO.setPayOrderModel(payOrderModel);
        logger.info("订单查询模型层转换:{}", acQueryPayRepVO);
        return acQueryPayRepVO;
    }
}