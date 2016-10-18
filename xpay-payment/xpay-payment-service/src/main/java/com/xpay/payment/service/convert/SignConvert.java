/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.convert;

import com.xpay.common.enums.EnumSignStatus;
import com.xpay.payment.common.vo.customer.SignRepVO;
import com.xpay.payment.common.vo.customer.SignReqVO;
import com.xpay.payment.service.entity.SignEntity;

/**
 * @author qinshou
 * @version $Id: SignConvert.java, v 0.1 16/9/11 上午10:22 sxfans Exp $
 */
public class SignConvert {

    /**
     * @param signEntity
     * @param signReqVO
     * @return
     */
    public static SignEntity getSignEntity(SignEntity signEntity, SignReqVO signReqVO) {
        signEntity.setSignNo(signReqVO.getSignNo());
        signEntity.setBreakSignNo(signReqVO.getBreakSignNo());
        signEntity.setCardNo(signReqVO.getCardNo());
        if (signReqVO.getCardType() != null) {
            signEntity.setCardType(signReqVO.getCardType().getKey());
        }
        signEntity.setCerNo(signReqVO.getCerNo());
        signEntity.setHolderName(signReqVO.getHolderName());
        signEntity.setExpireDate(signReqVO.getExpireDate());
        signEntity.setMobileNo(signReqVO.getMobileNo());
        signEntity.setRemark(signReqVO.getRemark());
        if (signReqVO.getSignStatus() != null) {
            signEntity.setSignStatus(signReqVO.getSignStatus().getKey());
        }
        if (signReqVO.getSignStatus() != null) {
            signEntity.setSignStatus(signReqVO.getSignStatus().getKey());
        }
        signEntity.setUserId(signReqVO.getUserId());
        signEntity.setBreakSignDT(signReqVO.getBreakSignDT());
        signEntity.setSignCreateDT(signReqVO.getSignCreateDT());
        signEntity.setSignFinishDT(signReqVO.getSignFinishDT());
        return signEntity;
    }

    /**
     * @param signRepVO
     * @param signEntity
     * @return
     */
    public static SignRepVO getSignRepVO(SignRepVO signRepVO, SignEntity signEntity) {
        signRepVO.setSignNo(signEntity.getSignNo());
        signRepVO.setBreakSignNo(signEntity.getBreakSignNo());
        signRepVO.setUserId(signEntity.getUserId());
        signRepVO.setSignCreateDT(signEntity.getSignCreateDT());
        signRepVO.setSignFinishDT(signEntity.getSignFinishDT());
        signRepVO.setBreakSignDT(signEntity.getBreakSignDT());
        signRepVO.setRemark(signEntity.getRemark());
        signRepVO.setSignStatus(EnumSignStatus.toSignStatus(signEntity.getSignStatus()));
        return signRepVO;
    }
}