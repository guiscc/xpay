/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.convert;

import com.xpay.channel.common.dto.customer.AuthRealNameRepChannelDTO;
import com.xpay.channel.common.dto.customer.AuthRealNameReqChannelDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.channel.common.vo.customer.AuthRealNameRepVO;
import com.xpay.channel.common.vo.customer.AuthRealNameReqVO;

/**
 * @author qinshou
 * @version $Id: AuthRealNameConvert.java, v 0.1 16/8/7 下午11:18 sxfans Exp $
 */
public class AuthRealNameConvert {

    private static final Logger logger = LoggerFactory.getLogger(AuthRealNameConvert.class);

    /**
     * @return
     */
    public static AuthRealNameReqVO getAuthRealNameReqVO(AuthRealNameReqVO authRealNameReqVO,
                                                         AuthRealNameReqChannelDTO authRealNameReqDTO) {
        logger.info("请求模型:{}", authRealNameReqDTO.toString());
        logger.info("转换请求模型:{}", authRealNameReqVO.toString());
        return authRealNameReqVO;
    }

    /**
     * @param authRealNameRepVO
     * @return
     */
    public static AuthRealNameRepChannelDTO getAuthRealNameRepVO(AuthRealNameRepChannelDTO authRealNameRepDTO,
                                                                 AuthRealNameRepVO authRealNameRepVO) {
        logger.info("响应模型:{}", authRealNameRepVO.toString());
        logger.info("转换响应模型:{}", authRealNameRepDTO.toString());
        return authRealNameRepDTO;
    }
}