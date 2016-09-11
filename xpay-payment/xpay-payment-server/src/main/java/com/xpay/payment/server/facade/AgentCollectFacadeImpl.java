/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.server.facade;

import com.xpay.payment.biz.AgentCollectBiz;
import com.xpay.payment.biz.convert.ACPayConvert;
import com.xpay.payment.biz.convert.ACQueryPayConvert;
import com.xpay.payment.common.dto.agentcollect.ACPayRepDTO;
import com.xpay.payment.common.dto.agentcollect.ACQueryPayReqDTO;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.facade.AgentCollectFacade;
import com.xpay.payment.common.dto.agentcollect.ACPayReqDTO;
import com.xpay.payment.common.dto.agentcollect.ACQueryPayRepDTO;
import com.xpay.payment.common.vo.agentcollect.ACPayRepVO;
import com.xpay.payment.common.vo.agentcollect.ACPayReqVO;
import com.xpay.payment.common.vo.agentcollect.ACQueryPayRepVO;
import com.xpay.payment.common.vo.agentcollect.ACQueryPayReqVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacadeImpl.java, v 0.1 16/8/6 下午9:27 sxfans Exp $
 */
public class AgentCollectFacadeImpl implements AgentCollectFacade {

    private Logger logger = LoggerFactory.getLogger(AgentCollectFacadeImpl.class);

    @Resource
    private AgentCollectBiz agentCollectBiz;

    @Override
    public ACPayRepDTO pay(ACPayReqDTO acPayReqDTO) {
        ACPayReqVO acPayReqVO = new ACPayReqVO();
        ACPayRepDTO acPayRepDTO = new ACPayRepDTO();
        try {
            acPayReqVO = ACPayConvert.getACPayReqVO(acPayReqVO, acPayReqDTO);
            ACPayRepVO acPayRepVO = agentCollectBiz.pay(acPayReqVO);
            acPayRepDTO = ACPayConvert.getACPayRepDTO(acPayRepDTO, acPayRepVO);
        } catch (XpayPaymentException e) {
            logger.error("代收异常:", e);
        } catch (Exception e) {
            logger.error("代收异常:", e);
        }
        return acPayRepDTO;
    }


    @Override
    public ACQueryPayRepDTO queryPay(ACQueryPayReqDTO acQueryPayReqDTO) {
        ACQueryPayReqVO acQueryPayReqVO = new ACQueryPayReqVO();
        ACQueryPayRepDTO acQueryPayRepDTO = new ACQueryPayRepDTO();
        try {
            acQueryPayReqVO = ACQueryPayConvert.getACQueryPayReqVO(acQueryPayReqVO, acQueryPayReqDTO);
            ACQueryPayRepVO acQueryPayRepVO = agentCollectBiz.queryPay(acQueryPayReqVO);
            acQueryPayRepDTO = ACQueryPayConvert.getACQueryPayRepDTO(acQueryPayRepDTO, acQueryPayRepVO);
        } catch (XpayPaymentException e) {
            logger.error("查询代收异常:", e);
        } catch (Exception e) {
            logger.error("查询代收异常:", e);
        }
        return acQueryPayRepDTO;
    }
}