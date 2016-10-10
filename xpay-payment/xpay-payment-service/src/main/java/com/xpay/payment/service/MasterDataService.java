/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service;

import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;

/**
 * @author qinshou
 * @version $Id: MasterDataService.java, v 0.1 16/10/10 上午11:20 sxfans Exp $
 */
public interface MasterDataService {

    /**
     * 获得卡bin
     *
     * @param cardBinReqVO
     * @return
     */
    public CardBinRepVO getCardBin(CardBinReqVO cardBinReqVO);
}