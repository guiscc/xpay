/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.impl;

import com.xpay.common.utils.sequence.RandomSequenceImpl;
import com.xpay.common.utils.sequence.Sequence;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.service.PaymentService;
import com.xpay.payment.dao.PaymentDao;
import com.xpay.payment.service.convert.PaymentConvert;
import com.xpay.payment.dao.entity.PaymentEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: PaymentService.java, v 0.1 16/8/29 下午1:24 sxfans Exp $
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    public PaymentDao paymentDao;

    @Override
    public PayOrderModel add(PayOrderModel payOrderModel) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity = PaymentConvert.convertPayOrderModel(paymentEntity, payOrderModel);
        PaymentEntity oldPaymentEntity = paymentDao.getByOrderNo(paymentEntity);
        if (oldPaymentEntity == null) {
            String seqNo = "";
            paymentEntity.setPayOrderNo(seqNo);
            paymentEntity.setCreateTime(new Date());
            int flag = paymentDao.add(paymentEntity);
            if (flag == 1) {
                oldPaymentEntity = paymentEntity;
            } else {
                return null;
            }
        }
        payOrderModel = PaymentConvert.convertPaymentEntity(payOrderModel, oldPaymentEntity);
        return payOrderModel;
    }

    @Override
    public boolean update(PayOrderModel payOrderModel) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity = PaymentConvert.convertPayOrderModel(paymentEntity, payOrderModel);
        paymentEntity.setUpdateTime(new Date());
        int flag = paymentDao.updateOrderStatus(paymentEntity);
        if (flag == 1) {
            return true;
        }
        return false;
    }

    @Override
    public PayOrderModel getByTradeOrderNo(String tradeOrderNo) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setTradeOrderNo(tradeOrderNo);
        PaymentEntity oldPaymentEntity = paymentDao.getByOrderNo(paymentEntity);
        if (oldPaymentEntity == null) {
            return null;
        }
        PayOrderModel payOrderModel = new PayOrderModel();
        PaymentConvert.convertPaymentEntity(payOrderModel, oldPaymentEntity);
        return payOrderModel;
    }

    @Override
    public PayOrderModel getByPayOrderNo(String payOrderNo) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPayOrderNo(payOrderNo);
        PaymentEntity oldPaymentEntity = paymentDao.getByOrderNo(paymentEntity);
        if (oldPaymentEntity == null) {
            return null;
        }
        PayOrderModel payOrderModel = new PayOrderModel();
        PaymentConvert.convertPaymentEntity(payOrderModel, oldPaymentEntity);
        return payOrderModel;
    }
}