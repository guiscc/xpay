/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.facade;

import com.xpay.payment.common.dto.masterdata.CardBinRepDTO;
import com.xpay.payment.common.dto.masterdata.CardBinReqDTO;

/**
 * @author qinshou
 * @version $Id: MasterDataFacade.java, v 0.1 16/10/10 上午8:18 sxfans Exp $
 */
public interface MasterDataFacade {

    /**
     * 获得卡bin
     *
     * @param cardBinReqDTO
     * @return
     */
    public CardBinRepDTO getCardBin(CardBinReqDTO cardBinReqDTO);
}