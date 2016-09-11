/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.biz;

import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.vo.agentcollect.ACPayReqVO;
import com.xpay.payment.common.vo.agentcollect.ACQueryPayRepVO;
import com.xpay.payment.common.vo.agentcollect.ACQueryPayReqVO;
import com.xpay.payment.common.vo.agentcollect.ACPayRepVO;

/**
 * @author qinshou
 * @version $Id: AgentCollectBiz.java, v 0.1 16/9/10 上午10:25 sxfans Exp $
 */
public interface AgentCollectBiz {

    /**
     * 代付
     *
     * @param acPayReqVO
     * @return
     */
    public ACPayRepVO pay(ACPayReqVO acPayReqVO) throws XpayPaymentException;

    /**
     * 代收
     *
     * @param acQueryPayReqVO
     * @return
     */
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayPaymentException;

}