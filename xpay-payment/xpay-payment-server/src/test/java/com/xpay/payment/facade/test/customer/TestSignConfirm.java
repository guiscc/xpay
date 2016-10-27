/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test.customer;

import com.xpay.payment.common.dto.customer.SignConfirmRepDTO;
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
    public void signConfirmNoExit() {
        SignConfirmReqDTO signConfirmReqDTO = new SignConfirmReqDTO();
        signConfirmReqDTO.setSignNo("112233");
        SignConfirmRepDTO signConfirmRepDTO = customerFacade.signConfirm(signConfirmReqDTO);
        System.out.println(signConfirmRepDTO);
    }

    @Test
    public void signConfirm() {
        SignConfirmReqDTO signConfirmReqDTO = new SignConfirmReqDTO();
        signConfirmReqDTO.setSignNo("2016100417274586800006525");
        signConfirmReqDTO.setVerifyCode("208956");
        SignConfirmRepDTO signConfirmRepDTO = customerFacade.signConfirm(signConfirmReqDTO);
        System.out.println(signConfirmRepDTO);
    }
}