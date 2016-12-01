/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.PayToolsBankEntity;

/**
 * @author qinshou
 * @version $Id: PayToolsBankDao.java, v 0.1 16/11/30 上午11:31 sxfans Exp $
 */
public interface PayToolsBankDao {

    /**
     * 交易使用
     * 获取支付工具对应的银行
     * @param payToolsBankEntity
     */
    public PayToolsBankEntity get(PayToolsBankEntity payToolsBankEntity);
}