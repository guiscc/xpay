/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.dao;

import com.xpay.payment.dao.entity.SignEntity;
import org.springframework.stereotype.Repository;

/**
 * @author qinshou
 * @version $Id: SignDao.java, v 0.1 16/9/11 上午10:10 sxfans Exp $
 */
@Repository
public interface SignDao {

    /**
     * 新增
     *
     * @param signEntity
     * @return
     */
    public int add(SignEntity signEntity);
    
    /**
     * 修改签约信息
     *
     * @param signEntity
     * @return
     */
    public int update(SignEntity signEntity);

    /**
     * 修改状态
     *
     * @param signEntity
     * @return
     */
    public int updateStatus(SignEntity signEntity);

    /**
     * 查找签约信息
     *
     * @param signEntity
     * @return
     */
    public SignEntity getBySignNo(SignEntity signEntity);

    /**
     * 查找签约信息
     *
     * @param signEntity
     * @return
     */
    public SignEntity getByCardNoAndName(SignEntity signEntity);
}