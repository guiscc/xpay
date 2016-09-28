/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test.customer;

import com.xpay.payment.common.dto.customer.SignBreakRepDTO;
import com.xpay.payment.common.dto.customer.SignBreakReqDTO;
import com.xpay.payment.common.facade.CustomerFacade;
import com.xpay.payment.facade.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestSignBreak.java, v 0.1 16/9/17 下午1:57 sxfans Exp $
 */
public class TestSignBreak extends BaseTest {

    @Resource
    private CustomerFacade customerFacade;

    @Test
    public void signBreak() {
        SignBreakReqDTO signBreakReqDTO = new SignBreakReqDTO();
        signBreakReqDTO.setSignNo("112233");
        SignBreakRepDTO signBreakRepDTO = customerFacade.signBreak(signBreakReqDTO);
        System.out.println(signBreakRepDTO);
    }
}