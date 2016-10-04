/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service.impl;

import com.xpay.payment.common.enums.EnumSignStatus;
import com.xpay.payment.common.vo.customer.*;
import com.xpay.payment.service.SignService;
import com.xpay.payment.service.convert.SignBreakConvert;
import com.xpay.payment.service.convert.SignConfirmConvert;
import com.xpay.payment.service.convert.SignConvert;
import com.xpay.payment.service.dao.SignDao;
import com.xpay.payment.service.entity.SignEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SignServiceImpl.java, v 0.1 16/9/11 上午10:13 sxfans Exp $
 */
@Service
public class SignServiceImpl implements SignService {

    @Resource
    private SignDao signDao;

    @Override
    public SignRepVO add(SignReqVO signReqVO) {
        SignEntity signEntity = new SignEntity();
        signEntity = SignConvert.getSignEntity(signEntity, signReqVO);
        signEntity.setSignCreateDT(new Date());
        int flag = signDao.add(signEntity);
        if (flag == 1) {
            SignRepVO signRepVO = SignConvert.getSignRepVO(new SignRepVO(), signEntity);
            return signRepVO;
        }
        return null;
    }

    @Override
    public SignRepVO update(SignReqVO signReqVO) {
        SignEntity signEntity = new SignEntity();
        signEntity = SignConvert.getSignEntity(signEntity, signReqVO);
        int flag = signDao.update(signEntity);
        if (flag == 1) {
            SignRepVO signRepVO = SignConvert.getSignRepVO(new SignRepVO(), signEntity);
            return signRepVO;
        }
        return null;
    }

    @Override
    public SignConfirmRepVO signConfirm(SignConfirmReqVO signConfirmReqVO) {
        SignEntity signEntity = new SignEntity();

        signEntity.setSignStatus(EnumSignStatus.SIGN_SUCCESS.getKey()); //设置签约状态
        signEntity.setSignFinishDT(new Date());

        signEntity = SignConfirmConvert.getSignEntity(signEntity, signConfirmReqVO);
        int flag = signDao.updateStatus(signEntity);
        if (flag == 1) {
            SignConfirmRepVO signConfirmRepVO = new SignConfirmRepVO();
            signConfirmRepVO = SignConfirmConvert.getSignConfirmRepVO(signConfirmRepVO, signEntity);
            return signConfirmRepVO;
        }
        return null;
    }

    @Override
    public SignBreakRepVO signBreak(SignBreakReqVO signBreakReqVO) {
        SignEntity signEntity = new SignEntity();
        signEntity = SignBreakConvert.getSignEntity(signEntity, signBreakReqVO);
        signEntity.setBreakSignDT(new Date());
        signEntity.setSignStatus(EnumSignStatus.BREAKSIGN_SUCCESS.getKey());
        int flag = signDao.updateStatus(signEntity);
        if (flag == 1) {
            SignBreakRepVO signBreakRepVO = new SignBreakRepVO();
            signBreakRepVO = SignBreakConvert.getSignBreakRepVO(signBreakRepVO, signEntity);
            return signBreakRepVO;
        }
        return null;
    }

    @Override
    public boolean updateStatus(SignReqVO signReqVO) {
        SignEntity signEntity = new SignEntity();
        signEntity = SignConvert.getSignEntity(signEntity, signReqVO);
        int flag = signDao.updateStatus(signEntity);
        if (flag != 1) {
            return false;
        }
        return true;
    }

    @Override
    public SignRepVO getBySignNo(SignReqVO signReqVO) {
        SignEntity signEntity = new SignEntity();
        signEntity = SignConvert.getSignEntity(signEntity, signReqVO);
        SignEntity oldSignEntity = signDao.getBySignNo(signEntity);
        if (oldSignEntity == null) {
            return null;
        }
        SignRepVO signRepVO = new SignRepVO();
        signRepVO = SignConvert.getSignRepVO(signRepVO, oldSignEntity);
        return signRepVO;
    }

    @Override
    public SignRepVO getByCardAndName(SignReqVO signReqVO) {
        SignEntity signEntity = new SignEntity();
        signEntity = SignConvert.getSignEntity(signEntity, signReqVO);
        SignEntity oldSignEntity = signDao.getByCardNoAndName(signEntity);
        if (oldSignEntity == null) {
            return null;
        }
        SignRepVO signRepVO = new SignRepVO();
        signRepVO = SignConvert.getSignRepVO(signRepVO, oldSignEntity);
        return signRepVO;
    }
}