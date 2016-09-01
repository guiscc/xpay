/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.convert;

import com.xpay.common.enums.EnumCurrency;
import com.xpay.common.enums.EnumPaySubTool;
import com.xpay.common.enums.EnumPayTool;
import com.xpay.payment.common.enums.EnumPayStatus;
import com.xpay.payment.common.model.PayOrderModel;
import com.xpay.payment.service.entity.PaymentEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author qinshou
 * @version $Id: PaymentConvert.java, v 0.1 16/8/29 下午4:22 sxfans Exp $
 */
public class PaymentConvert {

    /**
     * 转换模型
     *
     * @param paymentEntity
     * @param payOrderModel
     * @return
     */
    public static PaymentEntity convertPayOrderModel(PaymentEntity paymentEntity, PayOrderModel payOrderModel) {
        BeanUtils.copyProperties(payOrderModel, paymentEntity);
        if (payOrderModel.getPayStatus() != null) {
            paymentEntity.setPayStatus(payOrderModel.getPayStatus().getKey());
        }
        if (payOrderModel.getPayTool() != null) {
            paymentEntity.setPayTool(payOrderModel.getPayTool().getKey());
        }
        if (payOrderModel.getPaySubTool() != null) {
            paymentEntity.setPaySubTool(payOrderModel.getPaySubTool().getKey());
        }
        if (payOrderModel.getCurrency() != null) {
            paymentEntity.setCurrency(payOrderModel.getCurrency().getKey());
        }
        return paymentEntity;
    }

    /**
     * 转换模型
     *
     * @param payOrderModel
     * @param paymentEntity
     * @return
     */
    public static PayOrderModel convertPaymentEntity(PayOrderModel payOrderModel, PaymentEntity paymentEntity) {
        BeanUtils.copyProperties(paymentEntity, payOrderModel);
        payOrderModel.setPayTool(EnumPayTool.toPayTool(paymentEntity.getPayTool()));
        payOrderModel.setPaySubTool(EnumPaySubTool.toPaySubTool(paymentEntity.getPaySubTool()));
        payOrderModel.setCurrency(EnumCurrency.toCurrency(paymentEntity.getCurrency()));
        payOrderModel.setPayStatus(EnumPayStatus.toPayTool(paymentEntity.getPayStatus()));
        return payOrderModel;
    }
}