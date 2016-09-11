/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.agentcollect.ACQueryPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACQueryPayReqDTO;
import com.xpay.payment.common.vo.agentcollect.ACQueryPayRepVO;
import com.xpay.payment.common.vo.agentcollect.ACQueryPayReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
                                                     ACQueryPayReqDTO acQueryPayReqDTO) {
        logger.info("请求模型:", acQueryPayReqDTO.toString());
        logger.info("转换请求模型:", acQueryPayReqVO.toString());
        return acQueryPayReqVO;
    }

    /**
     * @param acQueryPayRepDTO
     * @param acQueryPayRepVO
     * @return
     */
    public static ACQueryPayRepDTO getACQueryPayRepDTO(ACQueryPayRepDTO acQueryPayRepDTO,
                                                       ACQueryPayRepVO acQueryPayRepVO) {
        logger.info("响应模型:", acQueryPayRepVO.toString());
        logger.info("转换响应模型:", acQueryPayRepDTO.toString());
        return acQueryPayRepDTO;
    }
}