/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.facade;

import com.xpay.common.enums.EnumRtnResult;
import com.xpay.payment.biz.MasterDataBiz;
import com.xpay.payment.biz.convert.CardBinConvert;
import com.xpay.payment.common.dto.masterdata.CardBinRepDTO;
import com.xpay.payment.common.dto.masterdata.CardBinReqDTO;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.facade.MasterDataFacade;
import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: MasterDataFacadeImpl.java, v 0.1 16/10/10 上午8:25 sxfans Exp $
 */
public class MasterDataFacadeImpl implements MasterDataFacade {

    private Logger logger = LoggerFactory.getLogger(MasterDataFacadeImpl.class);

    @Resource(name = "masterDataPaymentData")
    private MasterDataBiz masterDataBiz;

    @Override
    public CardBinRepDTO getCardBin(CardBinReqDTO cardBinReqDTO) {
        CardBinRepDTO cardBinRepDTO = new CardBinRepDTO();
        CardBinReqVO cardBinReqVO = new CardBinReqVO();
        try {
            cardBinReqVO = CardBinConvert.getCardBinReqVO(cardBinReqVO, cardBinReqDTO);
            CardBinRepVO cardBinRepVO = masterDataBiz.getCardBin(cardBinReqVO);
            cardBinRepDTO = CardBinConvert.getCardBinRepDTO(cardBinRepDTO, cardBinRepVO);
        } catch (XpayPaymentException e) {
            cardBinRepDTO.setRtnResult(e.getRtnResult());
            logger.error("获取卡bin错误", e);
        } catch (Exception e) {
            cardBinRepDTO.setRtnResult(EnumRtnResult.E000000);
            logger.error("获取卡bin错误", e);
        }
        return cardBinRepDTO;
    }
}