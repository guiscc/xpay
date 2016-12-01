/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.InstActEntity;
import org.springframework.stereotype.Repository;

/**
 * 机构结算账户
 * @author qinshou
 * @version $Id: InstActDao.java, v 0.1 16/11/30 上午11:29 sxfans Exp $
 */
@Repository
public interface InstActDao {

    /**
     * 根据机构编码查询
     * @param instCode
     * @return
     */
    public InstActEntity get(String instCode);
}