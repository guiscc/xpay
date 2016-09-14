/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.server.facade;

import com.xpay.payment.biz.AgentCollectBiz;
import com.xpay.payment.biz.convert.ACPayConvert;
import com.xpay.payment.biz.convert.ACQueryPayConvert;
import com.xpay.payment.biz.convert.ACRepairConvert;
import com.xpay.payment.common.dto.agentcollect.*;
import com.xpay.payment.common.exception.XpayPaymentException;
import com.xpay.payment.common.facade.AgentCollectFacade;
import com.xpay.payment.common.vo.agentcollect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacadeImpl.java, v 0.1 16/8/6 下午9:27 sxfans Exp $
 */
public class AgentCollectFacadeImpl implements AgentCollectFacade {

    private Logger logger = LoggerFactory.getLogger(AgentCollectFacadeImpl.class);

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

    @Override
    public ACRepairRepDTO repair(ACRepairReqDTO acRepairReqDTO) {
        ACRepairReqVO acRepairReqVO = new ACRepairReqVO();
        ACRepairRepDTO acRepairRepDTO = new ACRepairRepDTO();
        try {
            acRepairReqVO = ACRepairConvert.getACRepairReqVO(acRepairReqVO, acRepairReqDTO);
            ACRepairRepVO acRepairRepVO = agentCollectBiz.repair(acRepairReqVO);
            acRepairRepDTO = ACRepairConvert.getACRepairRepDTO(acRepairRepDTO, acRepairRepVO);
        } catch (XpayPaymentException e) {
            logger.error("补单异常", e);
        } catch (Exception e) {
            logger.error("补单异常", e);
        }
        return acRepairRepDTO;
    }


    /**
     * Getter method for property agentCollectBiz.
     *
     * @return property value of agentCollectBiz
     **/
    public AgentCollectBiz getAgentCollectBiz() {
        return agentCollectBiz;
    }

    /**
     * Setter method for property agentCollectBiz.
     *
     * @param agentCollectBiz value to be assigned to property agentCollectBiz
     **/
    public void setAgentCollectBiz(AgentCollectBiz agentCollectBiz) {
        this.agentCollectBiz = agentCollectBiz;
    }
}