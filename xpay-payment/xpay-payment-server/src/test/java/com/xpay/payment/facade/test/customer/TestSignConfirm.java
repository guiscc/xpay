/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test.customer;

import com.xpay.payment.common.dto.customer.SignConfirmReqDTO;
import com.xpay.payment.common.facade.CustomerFacade;
import com.xpay.payment.facade.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestSignConfirm.java, v 0.1 16/9/17 下午1:53 sxfans Exp $
 */
public class TestSignConfirm extends BaseTest {

    @Resource
    private CustomerFacade customerFacade;

    @Test
    public void signConfirm(){
        SignConfirmReqDTO signConfirmReqDTO = new SignConfirmReqDTO();
        signConfirmReqDTO.setSignNo("112233");
        customerFacade.signConfirm(signConfirmReqDTO);
    }
}