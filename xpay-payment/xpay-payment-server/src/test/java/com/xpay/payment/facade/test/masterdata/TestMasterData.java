/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.facade.test.masterdata;

import com.xpay.payment.common.dto.masterdata.CardBinRepDTO;
import com.xpay.payment.common.dto.masterdata.CardBinReqDTO;
import com.xpay.payment.common.facade.MasterDataFacade;
import com.xpay.payment.facade.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: TestMasterData.java, v 0.1 16/10/10 下午2:09 sxfans Exp $
 */
public class TestMasterData extends BaseTest {

    @Resource
    private MasterDataFacade masterDataFacade;

    @Test
    public void getCardBin() {
        CardBinReqDTO cardBinReqDTO = new CardBinReqDTO();
        cardBinReqDTO.setCardNo("6217730703774214");
        CardBinRepDTO cardBinRepDTO = masterDataFacade.getCardBin(cardBinReqDTO);
        System.out.println(cardBinRepDTO);
    }
}