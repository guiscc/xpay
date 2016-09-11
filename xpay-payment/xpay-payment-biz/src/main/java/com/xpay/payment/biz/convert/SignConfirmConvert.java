/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.customer.SignConfirmRepDTO;
import com.xpay.payment.common.dto.customer.SignConfirmReqDTO;
import com.xpay.payment.common.vo.customer.SignConfirmRepVO;
import com.xpay.payment.common.vo.customer.SignConfirmReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinshou
 * @version $Id: SignConfirmConvert.java, v 0.1 16/9/10 下午2:04 sxfans Exp $
 */
public class SignConfirmConvert {

    private static final Logger logger = LoggerFactory.getLogger(SignConfirmConvert.class);

    /**
     *
     * @param signConfirmReqVO
     * @param signConfirmReqDTO
     * @return
     */
    public static SignConfirmReqVO getConfirmSignReqVO(SignConfirmReqVO signConfirmReqVO,
                                                       SignConfirmReqDTO signConfirmReqDTO) {
        logger.info("请求模型:", signConfirmReqDTO.toString());
        logger.info("转换请求模型:", signConfirmReqVO.toString());
        return signConfirmReqVO;
    }

    /**
     *
     * @param signConfirmRepDTO
     * @param signConfirmRepVO
     * @return
     */
    public static SignConfirmRepDTO getConfirmSignRepDTO(SignConfirmRepDTO signConfirmRepDTO,
                                                         SignConfirmRepVO signConfirmRepVO) {
        logger.info("响应模型:", signConfirmRepVO.toString());
        logger.info("转换响应模型:", signConfirmRepDTO.toString());
        return signConfirmRepDTO;
    }

}