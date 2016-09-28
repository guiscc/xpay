/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.server.facade;

import com.xpay.common.enums.EnumRtnResult;
import com.xpay.payment.biz.CustomerBiz;
import com.xpay.payment.biz.convert.AuthRealNameConvert;
import com.xpay.payment.biz.convert.SignBreakConvert;
import com.xpay.payment.biz.convert.SignConfirmConvert;
import com.xpay.payment.biz.convert.SignConvert;
import com.xpay.payment.common.dto.customer.*;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.facade.CustomerFacade;
import com.xpay.payment.common.vo.customer.AuthRealNameRepVO;
import com.xpay.payment.common.vo.customer.AuthRealNameReqVO;
import com.xpay.payment.common.vo.customer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qinshou
 * @version $Id: UserFacade.java, v 0.1 16/8/6 下午10:11 sxfans Exp $
 */
public class CustomerFacadeImpl implements CustomerFacade {

    private Logger logger = LoggerFactory.getLogger(CustomerFacadeImpl.class);

    private CustomerBiz customerBiz;

    @Override
    public AuthRealNameRepDTO authRealName(AuthRealNameReqDTO customerReqDTO) {
        AuthRealNameRepDTO authRealNameRepDTO = new AuthRealNameRepDTO();
        AuthRealNameReqVO authRealNameReqVO = new AuthRealNameReqVO();
        try {
            authRealNameReqVO = AuthRealNameConvert.getAuthRealNameReqVO(authRealNameReqVO, customerReqDTO);
            AuthRealNameRepVO authRealNameRepVO = customerBiz.authRealName(authRealNameReqVO);
            authRealNameRepDTO = AuthRealNameConvert.getAuthRealNameRepVO(authRealNameRepDTO, authRealNameRepVO);
        } catch (XpayPaymentException e) {
            authRealNameRepDTO.setRtnResult(e.getRtnResult());
            logger.error("实名认证错误", e);
        } catch (Exception e) {
            authRealNameRepDTO.setRtnResult(EnumRtnResult.E000000);
            logger.error("实名认证错误", e);
        }
        return authRealNameRepDTO;
    }

    @Override
    public SignRepDTO sign(SignReqDTO signReqDTO) {
        SignRepDTO signRepDTO = new SignRepDTO();
        SignReqVO signReqVO = new SignReqVO();
        try {
            signReqVO = SignConvert.getSignReqVO(signReqVO, signReqDTO);
            SignRepVO signRepVO = customerBiz.sign(signReqVO);
            signRepDTO = SignConvert.getSignRepDTO(signRepDTO, signRepVO);
        } catch (XpayPaymentException e) {
            signRepDTO.setRtnResult(e.getRtnResult());
            logger.error("签约异常:", e);
        } catch (Exception e) {
            signRepDTO.setRtnResult(EnumRtnResult.E000000);
            logger.error("签约异常:", e);
        }
        return signRepDTO;
    }

    @Override
    public SignConfirmRepDTO signConfirm(SignConfirmReqDTO signConfirmReqDTO) {
        SignConfirmRepDTO signConfirmRepDTO = new SignConfirmRepDTO();
        SignConfirmReqVO signConfirmReqVO = new SignConfirmReqVO();
        try {
            signConfirmReqVO = SignConfirmConvert.getConfirmSignReqVO(signConfirmReqVO, signConfirmReqDTO);
            SignConfirmRepVO signConfirmRepVO = customerBiz.signConfirm(signConfirmReqVO);
            signConfirmRepDTO = SignConfirmConvert.getConfirmSignRepDTO(signConfirmRepDTO, signConfirmRepVO);
        } catch (XpayPaymentException e) {
            signConfirmRepDTO.setRtnResult(e.getRtnResult());
            logger.error("签约确认异常:", e);
        } catch (Exception e) {
            signConfirmRepDTO.setRtnResult(EnumRtnResult.E000000);
            logger.error("签约确认异常:", e);
        }
        return signConfirmRepDTO;
    }

    @Override
    public SignBreakRepDTO signBreak(SignBreakReqDTO signBreakReqDTO) {
        SignBreakRepDTO signBreakRepDTO = new SignBreakRepDTO();
        SignBreakReqVO signBreakReqVO = new SignBreakReqVO();
        try {
            signBreakReqVO = SignBreakConvert.getSignBreakReqVO(signBreakReqVO, signBreakReqDTO);
            SignBreakRepVO signBreakRepVO = customerBiz.signBreak(signBreakReqVO);
            signBreakRepDTO = SignBreakConvert.getSignBreakRepDTO(signBreakRepDTO, signBreakRepVO);
        } catch (XpayPaymentException e) {
            signBreakRepDTO.setRtnResult(e.getRtnResult());
            logger.error("解约异常:", e);
        } catch (Exception e) {
            signBreakRepDTO.setRtnResult(EnumRtnResult.E000000);
            logger.error("解约异常:", e);
        }
        return signBreakRepDTO;
    }

    /**
     * Getter method for property customerBiz.
     *
     * @return property value of customerBiz
     **/
    public CustomerBiz getCustomerBiz() {
        return customerBiz;
    }

    /**
     * Setter method for property customerBiz.
     *
     * @param customerBiz value to be assigned to property customerBiz
     **/
    public void setCustomerBiz(CustomerBiz customerBiz) {
        this.customerBiz = customerBiz;
    }
}