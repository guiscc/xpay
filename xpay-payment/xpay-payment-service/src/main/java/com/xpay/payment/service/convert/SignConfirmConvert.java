/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.convert;

import com.xpay.common.enums.EnumSignStatus;
import com.xpay.payment.common.vo.customer.SignConfirmRepVO;
import com.xpay.payment.common.vo.customer.SignConfirmReqVO;
import com.xpay.payment.dao.entity.SignEntity;

/**
 * @author qinshou
 * @version $Id: SignConfirmConvert.java, v 0.1 16/9/13 上午8:46 sxfans Exp $
 */
public class SignConfirmConvert {

    /**
     * @param signConfirmReqVO
     * @return
     */
    public static SignEntity getSignEntity(SignEntity signEntity,
                                           SignConfirmReqVO signConfirmReqVO) {
        signEntity.setSignNo(signConfirmReqVO.getSignNo());
        return signEntity;
    }

    /**
     * @return
     */
    public static SignConfirmRepVO getSignConfirmRepVO(SignConfirmRepVO signConfirmRepVO,
                                                       SignEntity signEntity) {
        signConfirmRepVO.setSignNo(signEntity.getSignNo());
        signConfirmRepVO.setSignStatus(EnumSignStatus.toSignStatus(signEntity.getSignStatus()));
        signConfirmRepVO.setSignFinishDT(signEntity.getSignFinishDT());
        return signConfirmRepVO;
    }
}