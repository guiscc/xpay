/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.PayToolsBankEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: PayToolsBankDao.java, v 0.1 16/11/30 上午11:31 sxfans Exp $
 */
@Repository
public interface PayToolsBankDao {

    /**
     * 交易使用
     * 获取支付工具对应的银行
     * @param payToolsBankEntity
     */
//    public List<PayToolsBankEntity> get(PayToolsBankEntity payToolsBankEntity);


    /**
     * 根据,支付工具,支付工具子类型,机构
     *
     * @param payTools
     * @param paySubTools
     * @param instCode
     * @return
     */
    public PayToolsBankEntity get(int payTools,int paySubTools, String instCode);
}