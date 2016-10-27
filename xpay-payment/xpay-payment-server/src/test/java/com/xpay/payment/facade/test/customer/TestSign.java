/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test.customer;

import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.payment.biz.convert.SignConvert;
import com.xpay.payment.common.dto.customer.SignRepDTO;
import com.xpay.payment.common.dto.customer.SignReqDTO;
import com.xpay.payment.common.facade.CustomerFacade;
import com.xpay.payment.common.vo.customer.SignReqVO;
import com.xpay.payment.facade.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestSign.java, v 0.1 16/9/17 下午1:53 sxfans Exp $
 */
public class TestSign extends BaseTest {

    Logger logger = LoggerFactory.getLogger(TestSign.class);

    @Resource
    private CustomerFacade customerFacade;


    /**
     * 新增签约信息
     */
    @Test
    public void sign() {
        SignReqDTO signReqDTO = new SignReqDTO();
        signReqDTO.setUserId("208811112222");
        signReqDTO.setCardNo("6111122222");
        signReqDTO.setCardType(EnumCardType.CREDIT);
        signReqDTO.setCertNo("41020511112222333");
        signReqDTO.setCertType(EnumCertType.IDCARD);
        signReqDTO.setCvv2("003");
        signReqDTO.setExpireDate("0312");
        signReqDTO.setHolderName("sxfans");
        signReqDTO.setMobileNo("18317888059");
        signReqDTO.setSignOrderNo("201609179999");
        signReqDTO.setRemark("test");
        signReqDTO.setReqClientDT(new Date());
        SignRepDTO signRepDTO = customerFacade.sign(signReqDTO);
        System.out.println(signRepDTO.toString());
    }

    @Test
    public void signRepeat() {
        SignReqDTO signReqDTO = new SignReqDTO();
        signReqDTO.setUserId("208811112222");
        signReqDTO.setCardNo("6111122222");
        signReqDTO.setCardType(EnumCardType.DEBIT);
        signReqDTO.setCertNo("41020511112222333");
        signReqDTO.setCertType(EnumCertType.IDCARD);
        signReqDTO.setCvv2("003");
        signReqDTO.setExpireDate("0312");
        signReqDTO.setHolderName("sxfans");
        signReqDTO.setMobileNo("18317888050");
        signReqDTO.setSignOrderNo("201609179999");
        signReqDTO.setRemark("test");
        signReqDTO.setReqClientDT(new Date());
        SignRepDTO signRepDTO = customerFacade.sign(signReqDTO);
        System.out.println(signRepDTO.toString());
    }
}