/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz.impl;

import com.xpay.common.enums.EnumRtnResult;
import com.xpay.common.utils.sequence.RandomSequenceImpl;
import com.xpay.common.utils.sequence.Sequence;
import com.xpay.payment.biz.CustomerBiz;
import com.xpay.payment.common.enums.EnumSignStatus;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.customer.AuthRealNameRepVO;
import com.xpay.payment.common.vo.customer.AuthRealNameReqVO;
import com.xpay.payment.common.vo.customer.*;
import com.xpay.payment.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: CustomerBizImpl.java, v 0.1 16/8/7 上午1:06 sxfans Exp $
 */
@Component
public class CustomerBizImpl implements CustomerBiz {

    private static final Logger logger = LoggerFactory.getLogger(CustomerBizImpl.class);

    @Resource
    private SignService signService;

    private static Sequence sequence = new RandomSequenceImpl();

    @Override
    public AuthRealNameRepVO authRealName(AuthRealNameReqVO authRealNameReqDTO) {
        logger.info("暂未实现");
        return null;
    }

    @Override
    public SignRepVO sign(SignReqVO signReqVO) throws XpayPaymentException {

        //查询签约信息是否存在
        SignRepVO oldSignRepVO = signService.getByCardAndName(signReqVO);

        if (oldSignRepVO != null) {
            //如果存在并且成功返回异常,签约已经成功
            if (EnumSignStatus.SIGN_SUCCESS.equals(oldSignRepVO.getSignStatus())) {
                throw new XpayPaymentException(EnumRtnResult.E000006);
            } else { //如果存在修改签约信息
                boolean flag = signService.updateStatus(signReqVO);
                if (!flag) {
                    throw new XpayPaymentException(EnumRtnResult.E000005);
                }
            }
            return oldSignRepVO;
        } else {
            String seqNo = sequence.getSeq(null);
            signReqVO.setSignNo(seqNo); //设置签约号
            signReqVO.setSignStatus(EnumSignStatus.SIGN_WAITING); //设置签约状态
            SignRepVO signRepVO = signService.add(signReqVO);
            //如果信息为空则新增签约信息失败
            if (signRepVO == null) {
                throw new XpayPaymentException(EnumRtnResult.E000005);
            }
            return signRepVO;
        }
    }

    @Override
    public SignConfirmRepVO signConfirm(SignConfirmReqVO signConfirmReqVO) throws XpayPaymentException {

        //查询签约信息
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo(signConfirmReqVO.getSignNo());
        SignRepVO signRepVO = signService.getBySignNo(signReqVO);

        //签约信息为空则终止交易
        if (signRepVO == null) {
            throw new XpayPaymentException(EnumRtnResult.E000007);
        }

        //签约状态为成功
        if (EnumSignStatus.SIGN_SUCCESS.equals(signRepVO.getSignStatus())) {
            throw new XpayPaymentException(EnumRtnResult.E000006);
        }

        //签约确认
        SignConfirmRepVO signConfirmRepVO = signService.signConfirm(signConfirmReqVO);
        if (signConfirmRepVO == null) {
            throw new XpayPaymentException(EnumRtnResult.E000008);
        }
        return signConfirmRepVO;
    }

    @Override
    public SignBreakRepVO signBreak(SignBreakReqVO signBreakReqVO) throws XpayPaymentException {

        //查询签约信息
        SignReqVO signReqVO = new SignReqVO();
        signReqVO.setSignNo(signBreakReqVO.getSignNo());
        SignRepVO signRepVO = signService.getBySignNo(signReqVO);

        //签约返回状态
        if (signRepVO == null) {
            throw new XpayPaymentException(EnumRtnResult.E000007);
        }

        //签约状态为成功
        SignBreakRepVO signBreakRepVO = signService.signBreak(signBreakReqVO);
        if (signBreakRepVO == null) {
            throw new XpayPaymentException(EnumRtnResult.E000009);
        }
        return signBreakRepVO;
    }
}