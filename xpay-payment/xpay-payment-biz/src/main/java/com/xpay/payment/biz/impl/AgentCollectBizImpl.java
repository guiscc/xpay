/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.common.enums.EnumPayStatus;
import com.xpay.common.enums.EnumRtnResult;
import com.xpay.payment.biz.AgentCollectBiz;
import com.xpay.payment.biz.convert.ACPayConvert;
import com.xpay.payment.biz.convert.ACQueryPayConvert;
import com.xpay.payment.biz.convert.ACRepairConvert;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.common.vo.agentcollect.*;
import com.xpay.payment.service.PaymentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: AgentCollectBizImpl.java, v 0.1 16/9/10 上午10:25 sxfans Exp $
 */
@Component(value = "acPaymentBiz")
public class AgentCollectBizImpl implements AgentCollectBiz {

    @Resource
    private PaymentService paymentService;

    @Override
    public ACPayRepVO pay(ACPayReqVO acPayReqVO) throws XpayPaymentException {
        PayOrderModel payOrderModel = new PayOrderModel();
        payOrderModel = ACPayConvert.getPayOrderModel(payOrderModel, acPayReqVO);
        payOrderModel.setPayStatus(EnumPayStatus.WAITING);
        PayOrderModel addModel = paymentService.add(payOrderModel);
        if (addModel == null) {
            throw new XpayPaymentException(EnumRtnResult.E000004);
        }
        ACPayRepVO acPayRepVO = new ACPayRepVO();
        acPayRepVO = ACPayConvert.getACPayRepVO(acPayRepVO, addModel);
        return acPayRepVO;
    }

    @Override
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayPaymentException {
        ACQueryPayRepVO acQueryPayRepVO = new ACQueryPayRepVO();
        PayOrderModel payOrderModel = null;
        if (StringUtils.isNotBlank(acQueryPayReqVO.getPayOrderNo())) {
            payOrderModel = paymentService.getByPayOrderNo(acQueryPayReqVO.getPayOrderNo());
        } else {
            payOrderModel = paymentService.getByTradeOrderNo(acQueryPayReqVO.getTradeOrderNo());
        }
        if (payOrderModel == null) {
            throw new XpayPaymentException(EnumRtnResult.E000001);
        }
        acQueryPayRepVO = ACQueryPayConvert.getACQueryPayRepVO(acQueryPayRepVO, payOrderModel);
        return acQueryPayRepVO;
    }

    @Override
    public ACRepairRepVO repair(ACRepairReqVO acRepairReqVO) throws XpayPaymentException {
        PayOrderModel payOrderModel = null;
        if (StringUtils.isNotBlank(acRepairReqVO.getPayOrderNo())) {
            payOrderModel = paymentService.getByPayOrderNo(acRepairReqVO.getPayOrderNo());
        } else {
            payOrderModel = paymentService.getByTradeOrderNo(acRepairReqVO.getTradeOrderNo());
        }
        if (payOrderModel == null) {
            throw new XpayPaymentException(EnumRtnResult.E000001);
        }
        if (EnumPayStatus.UNKNOW.getKey() == payOrderModel.getPayStatus().getKey()) {
            System.out.println("需要补单");
            payOrderModel.setPayStatus(EnumPayStatus.SUCCESS);
            boolean flag = paymentService.update(payOrderModel);
            if (!flag) {
                throw new XpayPaymentException(EnumRtnResult.E000004);
            }
        }
        ACRepairRepVO acRepairRepVO = new ACRepairRepVO();
        acRepairRepVO = ACRepairConvert.getACRepairRepVO(acRepairRepVO, payOrderModel);
        return acRepairRepVO;
    }
}