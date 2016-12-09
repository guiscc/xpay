/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.dao;

import com.xpay.payment.service.dao.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

/**
 * @author qinshou
 * @version $Id: PaymentDao.java, v 0.1 16/8/29 上午2:08 sxfans Exp $
 */
@Repository
public interface PaymentDao {

    /**
     * 根据交易号查询查询
     * @param paymentEntity
     * @return
     */
    public PaymentEntity getByOrderNo(PaymentEntity paymentEntity);

    /**
     * 新增订单
     * @param paymentEntity
     * @return
     */
    public int add(PaymentEntity paymentEntity);

    /**
     * 更新订单信息
     * @param paymentEntity
     * @return
     */
    public int updateOrderStatus(PaymentEntity paymentEntity);
}