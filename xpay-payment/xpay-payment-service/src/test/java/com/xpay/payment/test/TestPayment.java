/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.test;

import com.xpay.common.enums.EnumCurrency;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import com.xpay.payment.common.enums.EnumPayStatus;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.common.vo.agentcollect.UpPayOrderStatusReqVO;
import com.xpay.payment.service.PaymentService;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: TestPayment.java, v 0.1 16/8/29 下午8:28 sxfans Exp $
 */
public class TestPayment extends BaseTest {

    @Resource
    private PaymentService paymentService;

    @Test
    public void getByTradeOrderNo() {
        PayOrderModel payOrderModel = paymentService.getByTradeOrderNo("13a");
        System.out.println(payOrderModel);
    }

    @Test
    public void getByPayOrderNo() {
        PayOrderModel payOrderModel = paymentService.getByPayOrderNo("12a");
        System.out.println(payOrderModel);
    }

    @Test
    public void updatePayOrderStatus() {
        UpPayOrderStatusReqVO upOrderStatusReqVO = new UpPayOrderStatusReqVO();
        upOrderStatusReqVO.setTradeOrderNo("13");
        upOrderStatusReqVO.setPayOrderStatus(EnumPayStatus.FAIL);
        PayOrderModel payOrderModel = new PayOrderModel();
        payOrderModel.setTradeOrderNo("13");
        payOrderModel.setPayStatus(EnumPayStatus.FAIL);
        boolean flag = paymentService.update(payOrderModel);
        System.out.println(flag);
    }

    @Test
    public void add() {
        PayOrderModel payOrderModel = new PayOrderModel();

        payOrderModel.setTradeOrderNo("201609011644510001");
        payOrderModel.setPayOrderNo("P201609011644510001");
        payOrderModel.setPayStatus(EnumPayStatus.WAITING);
        payOrderModel.setCurrency(EnumCurrency.CNY);
        payOrderModel.setPayAmt(new BigDecimal("11"));
        payOrderModel.setPayTool(EnumPayTool.BANKCARD);
        payOrderModel.setPaySubTool(EnumPaySubTool.AGENTCOLLECT);

        payOrderModel.setChannelCode("aaa");
        payOrderModel.setCreateTime(new Date());
        payOrderModel.setUpdateTime(new Date());
        payOrderModel.setUserId("123123123");
        payOrderModel.setRemark("备注");
        PayOrderModel perPayModel = paymentService.add(payOrderModel);
        System.out.println(perPayModel.toString());
    }
}