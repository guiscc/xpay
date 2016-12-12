/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.convert;

import com.xpay.common.enums.EnumSignStatus;
import com.xpay.payment.common.vo.customer.SignBreakRepVO;
import com.xpay.payment.common.vo.customer.SignBreakReqVO;
import com.xpay.payment.dao.entity.SignEntity;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SignBreakConvert.java, v 0.1 16/9/13 上午8:45 sxfans Exp $
 */
public class SignBreakConvert {

    /**
     * 转换签约实体
     *
     * @param signEntity
     * @param signBreakReqVO
     * @return
     */
    public static SignEntity getSignEntity(SignEntity signEntity, SignBreakReqVO signBreakReqVO) {
        signEntity.setSignNo(signBreakReqVO.getSignNo());
        signEntity.setBreakSignNo(signBreakReqVO.getBreakSignNo());
        signEntity.setSignStatus(EnumSignStatus.BREAKSIGN_SUCCESS.getKey());
        signEntity.setBreakSignDT(new Date());
        return signEntity;
    }

    /**
     * 解约实体转换
     *
     * @param signBreakRepVO
     * @param signEntity
     * @return
     */
    public static SignBreakRepVO getSignBreakRepVO(SignBreakRepVO signBreakRepVO, SignEntity signEntity) {
        signBreakRepVO.setSignNo(signEntity.getSignNo());
        signBreakRepVO.setSignStatus(EnumSignStatus.toSignStatus(signEntity.getSignStatus()));
        signBreakRepVO.setBreakSignNo(signEntity.getBreakSignNo());
        signBreakRepVO.setBreakSignDT(signEntity.getBreakSignDT());
        return signBreakRepVO;
    }
}