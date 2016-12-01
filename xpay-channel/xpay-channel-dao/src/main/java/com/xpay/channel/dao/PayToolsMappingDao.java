/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.PayToolsMappingEntity;

/**
 * @author qinshou
 * @version $Id: PayToolsMappingDao.java, v 0.1 16/11/30 上午11:33 sxfans Exp $
 */
public interface PayToolsMappingDao {

    /**
     * 根据支付工具子类型对应的银行,查找相应的通道
     * @param payToolsMappingEntity
     * @return
     */
    public PayToolsMappingEntity get(PayToolsMappingEntity payToolsMappingEntity);
}