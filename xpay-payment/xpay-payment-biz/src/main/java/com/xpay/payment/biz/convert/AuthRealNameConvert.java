/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.customer.AuthRealNameRepDTO;
import com.xpay.payment.common.dto.customer.AuthRealNameReqDTO;
import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinshou
 * @version $Id: AuthRealNameConvert.java, v 0.1 16/8/7 下午11:18 sxfans Exp $
 */
public class AuthRealNameConvert {

    private static final Logger logger = LoggerFactory.getLogger(AuthRealNameConvert.class);

    /**
     * @return
     */
    public static AuthRealNameReqVO getAuthRealNameReqVO(AuthRealNameReqDTO authRealNameReqDTO) {
        logger.info("##########请求参数:", authRealNameReqDTO);
        AuthRealNameReqVO authRealNameReqVO = new AuthRealNameReqVO();
        return authRealNameReqVO;
    }

    /**
     * @param authRealNameRepVO
     * @return
     */
    public static AuthRealNameRepDTO getAuthRealNameRepVO(AuthRealNameRepVO authRealNameRepVO) {
        AuthRealNameRepDTO authRealNameRepDTO = new AuthRealNameRepDTO();
        return authRealNameRepDTO;
    }
}