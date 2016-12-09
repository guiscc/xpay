/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.PayToolsBankEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: PayToolsBankDao.java, v 0.1 16/11/30 上午11:31 sxfans Exp $
 */
@Repository
public interface PayToolsBankDao {

    /**
     * 根据,支付工具,支付工具子类型,卡类型,机构
     * @param payTools
     * @param paySubTools
     * @param cardType
     * @param instCode
     * @return
     */
    public PayToolsBankEntity get(@Param(value = "payTool") int payTools,
                                  @Param(value = "paySubTool") int paySubTools,
                                  @Param(value = "cardType") int cardType,
                                  @Param(value = "instCode") String instCode);

}