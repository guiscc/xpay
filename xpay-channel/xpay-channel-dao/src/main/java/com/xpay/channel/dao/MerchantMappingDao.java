/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.MerchantMappingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: MerchantMappingDao.java, v 0.1 16/12/5 下午2:16 sxfans Exp $
 */
@Repository
public interface MerchantMappingDao {

    /**
     * 根据渠道编码查询映射的商户号
     * @param merchantCodes
     * @return
     */
    public List<MerchantMappingEntity> findByInstCode(String merchantCodes);
}