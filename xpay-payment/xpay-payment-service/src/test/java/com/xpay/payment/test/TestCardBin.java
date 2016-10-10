/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.test;

import com.xpay.payment.common.vo.masterdata.CardBinRepVO;
import com.xpay.payment.common.vo.masterdata.CardBinReqVO;
import com.xpay.payment.service.MasterDataService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestCardBin.java, v 0.1 16/10/10 下午1:16 sxfans Exp $
 */
public class TestCardBin extends BaseTest {

    @Resource
    private MasterDataService masterDataService;

    @Test
    public void getCardBin() {
        CardBinReqVO cardBinReqVO = new CardBinReqVO();
        cardBinReqVO.setCardNo("6217730703774214");
        CardBinRepVO cardBinRepVO = masterDataService.getCardBin(cardBinReqVO);
        System.out.println(cardBinRepVO);
    }
}