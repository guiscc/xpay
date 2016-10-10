/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.impl;

import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;
import com.xpay.payment.service.MasterDataService;
import com.xpay.payment.service.convert.CardBinConvert;
import com.xpay.payment.service.dao.CardBinDao;
import com.xpay.payment.service.entity.CardBinEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: MasterDataServiceImpl.java, v 0.1 16/10/10 上午11:22 sxfans Exp $
 */
@Service
public class MasterDataServiceImpl implements MasterDataService {

    @Resource
    private CardBinDao cardBinDao;

    @Override
    public CardBinRepVO getCardBin(CardBinReqVO cardBinReqVO) {
        CardBinEntity cardBinEntity = cardBinDao.getCardBin(cardBinReqVO.getCardNo());
        if (cardBinEntity == null) {
            return null;
        }
        CardBinRepVO cardBinRepVO = new CardBinRepVO();
        cardBinRepVO = CardBinConvert.cardBinRepVO(cardBinRepVO, cardBinEntity);
        return cardBinRepVO;
    }
}