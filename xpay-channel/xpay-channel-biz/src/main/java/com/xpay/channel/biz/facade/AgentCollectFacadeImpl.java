/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.facade;

import com.xpay.channel.common.dto.agentcollect.*;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.facade.AgentCollectFacade;
import com.xpay.channel.common.vo.agentcollect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpay.common.enums.EnumRtnResult;
import com.xpay.channel.biz.AgentCollectBiz;
import com.xpay.channel.biz.convert.ACPayConvert;
import com.xpay.channel.biz.convert.ACQueryPayConvert;
import com.xpay.channel.biz.convert.ACRepairConvert;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: AgentCollectFacadeImpl.java, v 0.1 16/8/6 下午9:27 sxfans Exp $
 */
public class AgentCollectFacadeImpl implements AgentCollectFacade {

    private Logger          logger = LoggerFactory.getLogger(AgentCollectFacadeImpl.class);

    @Resource
    private AgentCollectBiz agentCollectBiz;

    @Override
    public ACPayRepChannelDTO pay(ACPayReqChannelDTO acPayReqDTO) {
        ACPayReqVO acPayReqVO = new ACPayReqVO();
        ACPayRepChannelDTO acPayRepDTO = new ACPayRepChannelDTO();
        try {
            acPayReqVO = ACPayConvert.getACPayReqVO(acPayReqVO, acPayReqDTO);
            ACPayRepVO acPayRepVO = agentCollectBiz.pay(acPayReqVO);
            acPayRepDTO = ACPayConvert.getACPayRepDTO(acPayRepDTO, acPayRepVO);
        } catch (XpayChannelException e) {
            logger.error("代收异常:", e);
            acPayRepDTO.setRtnResult(e.getRtnResult());
        } catch (Exception e) {
            logger.error("代收异常:", e);
            acPayRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return acPayRepDTO;
    }

    @Override
    public ACQueryPayRepChannelDTO queryPay(ACQueryPayReqChannelDTO acQueryPayReqDTO) {
        ACQueryPayReqVO acQueryPayReqVO = new ACQueryPayReqVO();
        ACQueryPayRepChannelDTO acQueryPayRepDTO = new ACQueryPayRepChannelDTO();
        try {
            acQueryPayReqVO = ACQueryPayConvert.getACQueryPayReqVO(acQueryPayReqVO,
                acQueryPayReqDTO);
            ACQueryPayRepVO acQueryPayRepVO = agentCollectBiz.queryPay(acQueryPayReqVO);
            acQueryPayRepDTO = ACQueryPayConvert.getACQueryPayRepDTO(acQueryPayRepDTO,
                acQueryPayRepVO);
        } catch (XpayChannelException e) {
            logger.error("查询代收异常:", e);
            acQueryPayRepDTO.setRtnResult(e.getRtnResult());
        } catch (Exception e) {
            logger.error("查询代收异常:", e);
            acQueryPayRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return acQueryPayRepDTO;
    }

    @Override
    public ACRepairRepChannelDTO repair(ACRepairReqChannelDTO acRepairReqDTO) {
        ACRepairReqVO acRepairReqVO = new ACRepairReqVO();
        ACRepairRepChannelDTO acRepairRepDTO = new ACRepairRepChannelDTO();
        try {
            acRepairReqVO = ACRepairConvert.getACRepairReqVO(acRepairReqVO, acRepairReqDTO);
            ACRepairRepVO acRepairRepVO = agentCollectBiz.repair(acRepairReqVO);
            acRepairRepDTO = ACRepairConvert.getACRepairRepDTO(acRepairRepDTO, acRepairRepVO);
        } catch (XpayChannelException e) {
            logger.error("补单异常", e);
            acRepairRepDTO.setRtnResult(e.getRtnResult());
        } catch (Exception e) {
            logger.error("补单异常", e);
            acRepairRepDTO.setRtnResult(EnumRtnResult.E000000);
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