/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.payment.biz.MasterDataBiz;
import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;
import com.xpay.payment.service.MasterDataService;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: MasterDataBizImpl.java, v 0.1 16/10/10 下午1:42 sxfans Exp $
 */
public class MasterDataBizImpl implements MasterDataBiz {

    @Resource
    private MasterDataService masterDataService;

    @Override
    public CardBinRepVO getCardBin(CardBinReqVO cardBinReqVO) {
        return masterDataService.getCardBin(cardBinReqVO);
    }
}