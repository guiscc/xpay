/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.dto.customer.SignBreakRepChannelDTO;
import com.xpay.channel.common.dto.customer.SignBreakReqChannelDTO;
import com.xpay.channel.common.vo.customer.SignBreakRepVO;
import com.xpay.channel.common.vo.customer.SignBreakReqVO;

/**
 * @author qinshou
 * @version $Id: SignBreakConvert.java, v 0.1 16/9/10 下午4:32 sxfans Exp $
 */
public class SignBreakConvert {

    private static final Logger logger = LoggerFactory.getLogger(SignBreakConvert.class);

    public static SignBreakReqVO getSignBreakReqVO(SignBreakReqVO signBreakReqVO,
                                                   SignBreakReqChannelDTO signBreakReqDTO) {
        logger.info("请求模型:{}", signBreakReqDTO);
        signBreakReqVO.setSignNo(signBreakReqDTO.getSignNo());
        logger.info("转换请求模型:{}", signBreakReqVO);
        return signBreakReqVO;
    }

    public static SignBreakRepChannelDTO getSignBreakRepDTO(SignBreakRepChannelDTO signBreakRepDTO,
                                                            SignBreakRepVO signBreakRepVO) {
        logger.info("响应模型:{}", signBreakRepVO.toString());
        signBreakRepDTO.setSignNo(signBreakRepVO.getSignNo());
        signBreakRepDTO.setSignStatus(signBreakRepVO.getSignStatus());
        signBreakRepDTO.setBreakSignNo(signBreakRepVO.getBreakSignNo());
        signBreakRepDTO.setBreakSignDT(signBreakRepVO.getBreakSignDT());
        logger.info("转换响应模型:{}", signBreakRepDTO.toString());
        return signBreakRepDTO;
    }
}