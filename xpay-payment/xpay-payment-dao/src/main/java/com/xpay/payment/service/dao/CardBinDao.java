/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.dao;

import com.xpay.payment.service.dao.entity.CardBinEntity;
import org.springframework.stereotype.Repository;

/**
 * @author qinshou
 * @version $Id: CardBinDao.java, v 0.1 16/10/10 上午11:24 sxfans Exp $
 */
@Repository
public interface CardBinDao {

    /**
     * 卡号
     *
     * @param cardNo
     * @return
     */
    public CardBinEntity getCardBin(String cardNo);
}