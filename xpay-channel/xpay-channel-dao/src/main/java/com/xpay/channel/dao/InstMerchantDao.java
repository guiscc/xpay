/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.InstMerchantEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 第三方商户持久化层
 * @author qinshou
 * @version $Id: InstMerchantDao.java, v 0.1 16/11/30 上午11:30 sxfans Exp $
 */
@Repository
public interface InstMerchantDao {

    /**
     * 根据机构找到对应的商户信息
     * @param codes
     * @return
     */
    public List<InstMerchantEntity> findByInstCode(String codes);
}