/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.dto.customer.SignConfirmRepDTO;
import com.xpay.channel.common.dto.customer.SignConfirmReqDTO;
import com.xpay.channel.common.vo.customer.SignConfirmRepVO;
import com.xpay.channel.common.vo.customer.SignConfirmReqVO;

/**
 * @author qinshou
 * @version $Id: SignConfirmConvert.java, v 0.1 16/9/10 下午2:04 sxfans Exp $
 */
public class SignConfirmConvert {

    private static final Logger logger = LoggerFactory.getLogger(SignConfirmConvert.class);

    /**
     * @param signConfirmReqVO
     * @param signConfirmReqDTO
     * @return
     */
    public static SignConfirmReqVO getConfirmSignReqVO(SignConfirmReqVO signConfirmReqVO,
                                                       SignConfirmReqDTO signConfirmReqDTO) {
        logger.info("请求模型:{}", signConfirmReqDTO.toString());
        signConfirmReqVO.setSignNo(signConfirmReqDTO.getSignNo());
        logger.info("转换请求模型:{}", signConfirmReqVO.toString());
        return signConfirmReqVO;
    }

    /**
     * @param signConfirmRepDTO
     * @param signConfirmRepVO
     * @return
     */
    public static SignConfirmRepDTO getConfirmSignRepDTO(SignConfirmRepDTO signConfirmRepDTO,
                                                         SignConfirmRepVO signConfirmRepVO) {
        logger.info("响应模型:{}", signConfirmRepVO.toString());
        signConfirmRepDTO.setSignNo(signConfirmRepVO.getSignNo());
        signConfirmRepDTO.setServerDate(new Date());
        logger.info("转换响应模型:{}", signConfirmRepDTO.toString());
        return signConfirmRepDTO;
    }

}