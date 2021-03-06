/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.PayToolsMappingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: PayToolsMappingDao.java, v 0.1 16/11/30 上午11:33 sxfans Exp $
 */
@Repository
public interface PayToolsMappingDao {

    /**
     * 根据支付工具子类型对应的银行,查找相应的通道
     * @param payToolBankCode
     * @return
     */
    public List<PayToolsMappingEntity> find(String payToolBankCode);
}