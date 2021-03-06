/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import java.util.Date;

import com.xpay.channel.common.dto.customer.SignRepChannelDTO;
import com.xpay.channel.common.dto.customer.SignReqChannelDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.vo.customer.SignRepVO;
import com.xpay.channel.common.vo.customer.SignReqVO;

/**
 * @author qinshou
 * @version $Id: SignConvert.java, v 0.1 16/9/6 下午4:42 sxfans Exp $
 */
public class SignConvert {

    private static final Logger logger = LoggerFactory.getLogger(SignConvert.class);

    /**
     * 签约请求
     *
     * @param signRepVO
     * @return
     */
    public static SignRepChannelDTO getSignRepDTO(SignRepChannelDTO signRepDTO, SignRepVO signRepVO) {
        logger.info("响应模型:{}", signRepVO);
        signRepDTO.setSignNo(signRepVO.getSignNo());
        signRepDTO.setSignStatus(signRepVO.getSignStatus());
        signRepDTO.setServerDate(new Date());
        logger.info("转换响应模型:{}", signRepDTO);
        return signRepDTO;
    }

    /**
     * 签约请求模型转换
     *
     * @return
     */
    public static SignReqVO getSignReqVO(SignReqVO signReqVO, SignReqChannelDTO signReqDTO) {
        logger.info("请求模型:{}", signReqDTO);
        signReqVO.setUserId(signReqDTO.getUserId());
        signReqVO.setCardNo(signReqDTO.getCardNo());
        signReqVO.setCardType(signReqDTO.getCardType());
        signReqVO.setCerNo(signReqDTO.getCertNo());
        signReqVO.setCerType(signReqDTO.getCertType());
        signReqVO.setCvv2(signReqDTO.getCvv2());
        signReqVO.setExpireDate(signReqDTO.getExpireDate());
        signReqVO.setHolderName(signReqDTO.getHolderName());
        signReqVO.setMobileNo(signReqDTO.getMobileNo());
        signReqVO.setSignOrderNo(signReqDTO.getSignOrderNo());
        signReqVO.setRemark(signReqDTO.getRemark());
        logger.info("转换请求模型:{}", signReqVO);
        return signReqVO;
    }
}