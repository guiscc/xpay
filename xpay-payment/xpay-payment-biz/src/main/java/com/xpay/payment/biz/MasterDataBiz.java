/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz;

import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;

/**
 * @author qinshou
 * @version $Id: MasterDataBiz.java, v 0.1 16/10/10 上午8:29 sxfans Exp $
 */
public interface MasterDataBiz {

    /**
     * @param cardBinReqVO
     * @return
     */
    public CardBinRepVO getCardBin(CardBinReqVO cardBinReqVO) throws XpayPaymentException;

    ;
}