/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.convert;

import com.xpay.payment.common.dto.masterdata.CardBinRepDTO;
import com.xpay.payment.common.dto.masterdata.CardBinReqDTO;
import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @author qinshou
 * @version $Id: CardBinConvert.java, v 0.1 16/10/10 下午1:37 sxfans Exp $
 */
public class CardBinConvert {

    private static final Logger logger = LoggerFactory.getLogger(SignBreakConvert.class);

    public static CardBinRepDTO getCardBinRepDTO(CardBinRepDTO cardBinRepDTO, CardBinRepVO cardBinRepVO) {
        logger.info("响应模型:{}", cardBinRepVO);
        BeanUtils.copyProperties(cardBinRepVO, cardBinRepDTO);
        logger.info("转换响应模型:{}", cardBinRepDTO);
        return cardBinRepDTO;
    }

    public static CardBinReqVO getCardBinReqVO(CardBinReqVO cardBinReqVO, CardBinReqDTO cardBinReqDTO) {
        logger.info("请求模型:{}", cardBinReqDTO);
        BeanUtils.copyProperties(cardBinReqDTO, cardBinReqVO);
        logger.info("转换请求模型:{}", cardBinReqVO);
        return cardBinReqVO;
    }
}