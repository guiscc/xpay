/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.InstitutionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 机构持久化类
 * @author qinshou
 * @version $Id: InstituionDao.java, v 0.1 16/11/30 上午11:29 sxfans Exp $
 */
@Repository
public interface InstituionDao {

    /**
     * 根据多个code查找codes
     * @param instCodes
     * @return
     */
    public List<InstitutionEntity> findByInstCodes(String instCodes);
}