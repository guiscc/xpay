/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.dto.masterdata;

import com.xpay.payment.common.dto.BaseReqDTO;

/**
 * @author qinshou
 * @version $Id: CardBinReqDTO.java, v 0.1 16/10/10 上午8:22 sxfans Exp $
 */
public class CardBinReqDTO extends BaseReqDTO {

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * Getter method for property cardNo.
     *
     * @return property value of cardNo
     **/
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Setter method for property cardNo.
     *
     * @param cardNo value to be assigned to property cardNo
     **/
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}