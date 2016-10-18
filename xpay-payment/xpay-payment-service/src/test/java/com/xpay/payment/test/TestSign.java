/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.test;

import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.common.enums.EnumSignStatus;
import com.xpay.payment.common.vo.customer.SignBreakRepVO;
import com.xpay.payment.common.vo.customer.SignBreakReqVO;
import com.xpay.payment.common.vo.customer.SignRepVO;
import com.xpay.payment.common.vo.customer.SignReqVO;
import com.xpay.payment.service.SignService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestSign.java, v 0.1 16/9/11 下午4:41 sxfans Exp $
 */
public class TestSign extends BaseTest {

    @Resource
    private SignService signService;

    @Test
    public void sign() {
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo("123456");
        signReqVO.setCardNo("622222111111");
        signReqVO.setCardType(EnumCardType.DEBIT);
        signReqVO.setHolderName("苏信心");
        signReqVO.setCerType(EnumCertType.IDCARD);
        signReqVO.setCerNo("410205111122223");
        signReqVO.setExpireDate("12/31");
        signReqVO.setMobileNo("18317888059");
        signReqVO.setSignCreateDT(new Date());
        signReqVO.setSignStatus(EnumSignStatus.SIGN_WAITING);
        signReqVO.setUserId("888888");
        signReqVO.setRemark("备注");
        SignRepVO signRepVO = signService.add(signReqVO);
        System.out.println("########"+signRepVO);
    }

    @Test
    public void getSign() {
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo("201608121212");
        SignRepVO signRepVO = signService.getBySignNo(signReqVO);
        System.out.println(signRepVO);
    }

    @Test
    public void signConfirm() {
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo("201608121212");
        signReqVO.setSignStatus(EnumSignStatus.SIGN_SUCCESS);
        signReqVO.setSignFinishDT(new Date());
        boolean flag = signService.updateStatus(signReqVO);
        System.out.println("#####" + flag);
    }

    @Test
    public void breakSign() {
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo("201608121212");
        signReqVO.setBreakSignNo("201608121212");
        signReqVO.setSignStatus(EnumSignStatus.BREAKSIGN_SUCCESS);
        signReqVO.setBreakSignDT(new Date());

        SignBreakReqVO signBreakReqVO = new SignBreakReqVO();
        SignBreakRepVO signBreakRepVO = signService.signBreak(signBreakReqVO);
        System.out.println("######" + signBreakRepVO);
    }


    @Test
    public void updateStatus() {
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo("201608121212");
        signReqVO.setBreakSignNo("201608121212");
        signReqVO.setSignStatus(EnumSignStatus.BREAKSIGN_SUCCESS);
        signReqVO.setBreakSignDT(new Date());
        boolean flag = signService.updateStatus(signReqVO);
        System.out.println("######" + flag);
    }
}