/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.server.facade;

import com.xpay.payment.biz.CustomerBiz;
import com.xpay.payment.biz.convert.AuthRealNameConvert;
import com.xpay.payment.common.dto.customer.*;
import com.xpay.payment.common.facade.CustomerFacade;
import com.xpay.payment.common.vo.AuthRealNameRepVO;
import com.xpay.payment.common.vo.AuthRealNameReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: UserFacade.java, v 0.1 16/8/6 下午10:11 sxfans Exp $
 */
public class CustomerFacadeImpl implements CustomerFacade {

    private Logger logger = LoggerFactory.getLogger(CustomerFacadeImpl.class);
    /**
     * 客户实现业务层
     */
    @Resource
    private CustomerBiz customerBiz;

    @Override
    public AuthRealNameRepDTO authRealName(AuthRealNameReqDTO customerReqDTO) {
        AuthRealNameRepDTO authRealNameRepDTO = new AuthRealNameRepDTO();
        try {
            AuthRealNameReqVO authRealNameReqVO = AuthRealNameConvert.getAuthRealNameReqVO(customerReqDTO);
            AuthRealNameRepVO authRealNameRepVO = customerBiz.authRealName(authRealNameReqVO);
            authRealNameRepDTO = AuthRealNameConvert.getAuthRealNameRepVO(authRealNameRepVO);
        } catch (Exception e) {
            logger.error("实名认证错误", e);
        }
        return authRealNameRepDTO;
    }

    @Override
    public SignRepDTO sign(SignReqDTO DTO) {
        SignRepDTO signRepDTO = new SignRepDTO();

        return null;
    }

    @Override
    public ConfirmSignRepDTO confirmSign(ConfirmSignReqDTO confirmSignRepDTO) {
        return null;
    }

    @Override
    public ConfirmSignRepDTO breakSign(ConfirmSignRepDTO confirmSignRepDTO) {
        return null;
    }


    public void sign() {

    }
}