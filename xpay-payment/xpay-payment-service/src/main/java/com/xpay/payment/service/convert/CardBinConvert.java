/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.convert;

import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.dao.entity.CardBinEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author qinshou
 * @version $Id: CardBinConvert.java, v 0.1 16/10/10 下午1:37 sxfans Exp $
 */
public class CardBinConvert {

    /**
     * 转换cardBin
     *
     * @param cardBinEntity
     * @return
     */
    public static CardBinRepVO cardBinRepVO(CardBinRepVO cardBinRepVO, CardBinEntity cardBinEntity) {
        BeanUtils.copyProperties(cardBinEntity, cardBinRepVO);
        return cardBinRepVO;
    }
}