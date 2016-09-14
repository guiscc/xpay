/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.agentcollect.ACPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACPayReqDTO;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.common.vo.agentcollect.ACPayRepVO;
import com.xpay.payment.common.vo.agentcollect.ACPayReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinshou
 * @version $Id: ACPayConvert.java, v 0.1 16/9/10 下午4:56 sxfans Exp $
 */
public class ACPayConvert {

    private static final Logger logger = LoggerFactory.getLogger(ACPayConvert.class);

    /**
     * 获取变量
     *
     * @param acPayReqVO
     * @param acPayReqDTO
     * @return
     */
    public static ACPayReqVO getACPayReqVO(ACPayReqVO acPayReqVO,
                                           ACPayReqDTO acPayReqDTO) {
        logger.info("请求模型:", acPayReqDTO.toString());
        logger.info("转换请求模型:", acPayReqVO.toString());
        return acPayReqVO;
    }

    /**
     * @param acPayRepDTO
     * @param acPayRepVO
     * @return
     */
    public static ACPayRepDTO getACPayRepDTO(ACPayRepDTO acPayRepDTO,
                                             ACPayRepVO acPayRepVO) {
        logger.info("响应模型:", acPayRepVO.toString());
        logger.info("转换响应模型:", acPayRepDTO.toString());
        return acPayRepDTO;
    }

    /**
     *
     * @param payOrderModel
     * @param acPayReqVO
     * @return
     */
    public static PayOrderModel getPayOrderModel(PayOrderModel payOrderModel, ACPayReqVO acPayReqVO) {
        return payOrderModel;
    }

    /**
     *
     * @param acPayRepVO
     * @param payOrderModel
     * @return
     */
    public static ACPayRepVO getACPayRepVO(ACPayRepVO acPayRepVO, PayOrderModel payOrderModel) {
        return acPayRepVO;
    }
}