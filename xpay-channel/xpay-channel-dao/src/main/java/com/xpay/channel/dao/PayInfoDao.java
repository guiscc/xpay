/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.PayInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @author qinshou
 * @version $Id: PayInfoDao.java, v 0.1 16/11/30 上午11:31 sxfans Exp $
 */
@Repository
public interface PayInfoDao {

    /**
     * 新增渠道单信息
     * @param payInfoEntity
     * @return
     */
    public int add(PayInfoEntity payInfoEntity);

    /**
     * 根据支付单号查询支付单信息
     * @return
     */
    public PayInfoEntity findByPayOrderNo(String payOrderNo);
}