/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz;

import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.agentcollect.*;

/**
 * @author qinshou
 * @version $Id: AgentCollectBiz.java, v 0.1 16/9/10 上午10:25 sxfans Exp $
 */
public interface AgentCollectBiz {

    /**
     * 代收
     *
     * @param acPayReqVO
     * @return
     * @throws XpayPaymentException
     */
    public ACPayRepVO pay(ACPayReqVO acPayReqVO) throws XpayPaymentException;

    /**
     * 代收
     *
     * @param acQueryPayReqVO
     * @return
     * @throws XpayPaymentException
     */
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayPaymentException;

    /**
     * 补单
     *
     * @param acRepairReqVO
     * @return
     * @throws XpayPaymentException
     */
    public ACRepairRepVO repair(ACRepairReqVO acRepairReqVO) throws XpayPaymentException;

}