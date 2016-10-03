/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.customer.SignBreakRepDTO;
import com.xpay.payment.common.dto.customer.SignBreakReqDTO;
import com.xpay.payment.common.vo.customer.SignBreakRepVO;
import com.xpay.payment.common.vo.customer.SignBreakReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinshou
 * @version $Id: SignBreakConvert.java, v 0.1 16/9/10 下午4:32 sxfans Exp $
 */
public class SignBreakConvert {

    private static final Logger logger = LoggerFactory.getLogger(SignBreakConvert.class);

    public static SignBreakReqVO getSignBreakReqVO(SignBreakReqVO signBreakReqVO,
                                                   SignBreakReqDTO signBreakReqDTO) {
        logger.info("请求模型:{}", signBreakReqDTO.toString());
        logger.info("转换请求模型:{}", signBreakReqVO.toString());
        return signBreakReqVO;
    }

    public static SignBreakRepDTO getSignBreakRepDTO(SignBreakRepDTO signBreakRepDTO,
                                                     SignBreakRepVO signBreakRepVO) {
        logger.info("响应模型:{}", signBreakRepVO.toString());
        logger.info("转换响应模型:{}", signBreakRepDTO.toString());
        return signBreakRepDTO;
    }
}