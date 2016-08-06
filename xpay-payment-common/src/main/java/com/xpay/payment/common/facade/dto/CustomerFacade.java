/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.facade.dto;

import com.xpay.payment.common.facade.dto.customer.CustomerRepDTO;
import com.xpay.payment.common.facade.dto.customer.CustomerReqDTO;

/**
 * 实名认证
 * @author qinshou
 * @version $Id: UserFacade.java, v 0.1 16/8/6 下午10:11 sxfans Exp $
 */
public interface CustomerFacade {

    /**
     * 实名认证
     * @param customerReqDTO
     * @return
     */
    public CustomerRepDTO authRealName(CustomerReqDTO customerReqDTO);
}