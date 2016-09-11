/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.customer.SignRepDTO;
import com.xpay.payment.common.dto.customer.SignReqDTO;
import com.xpay.payment.common.vo.customer.SignRepVO;
import com.xpay.payment.common.vo.customer.SignReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public static SignRepDTO getSignRepDTO(SignRepDTO signRepDTO, SignRepVO signRepVO) {
        logger.info("请求模型:", signRepDTO.toString());
        logger.info("转换请求模型:", signRepVO.toString());
        return signRepDTO;
    }

    /**
     * @return
     */
    public static SignReqVO getSignReqVO(SignReqVO signReqVO, SignReqDTO signReqDTO) {
        logger.info("响应模型:", signReqVO.toString());
        logger.info("转换响应模型:", signReqDTO.toString());
        return signReqVO;
    }
}