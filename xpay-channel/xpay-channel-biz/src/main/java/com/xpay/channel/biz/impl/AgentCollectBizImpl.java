/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.impl;

import com.xpay.channel.biz.AgentCollectBiz;
import com.xpay.channel.biz.convert.ACPayConvert;
import com.xpay.channel.biz.convert.ACQueryPayConvert;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.vo.agentcollect.*;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayReqFrontDTO;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: AgentCollectBizImpl.java, v 0.1 16/10/26 上午11:31 sxfans Exp $
 */
@Component
public class AgentCollectBizImpl implements AgentCollectBiz {

    @Resource
    private AgentCollectFrontFacade agentCollectFrontFacade;

    @Override
    public ACPayRepVO pay(ACPayReqVO acPayReqVO) throws XpayChannelException {
        ACPayReqFrontDTO acPayReqFrontDTO = new ACPayReqFrontDTO();
        acPayReqFrontDTO = ACPayConvert.getACPayReqFrontDTO(acPayReqFrontDTO, acPayReqVO);
        ACPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.pay(acPayReqFrontDTO);

        ACPayRepVO acPayRepVO = new ACPayRepVO();
        acPayRepVO = ACPayConvert.getACPayRepFrontDTO(acPayRepVO, acPayRepFrontDTO);
        return acPayRepVO;
    }

    @Override
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayChannelException {
        ACQueryPayReqFrontDTO acQueryPayReqFrontDTO = new ACQueryPayReqFrontDTO();
        acQueryPayReqFrontDTO = ACQueryPayConvert.getACQueryPayReqFrontDTO(acQueryPayReqFrontDTO,
            acQueryPayReqVO);
        ACQueryPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.payQuery(acQueryPayReqFrontDTO);

        ACQueryPayRepVO acQueryPayRepVO =new ACQueryPayRepVO();
        acQueryPayRepVO = ACQueryPayConvert.getACQueryPayRepVO(acQueryPayRepVO,acPayRepFrontDTO);
        return acQueryPayRepVO;
    }


    @Override
    public ACRepairRepVO repair(ACRepairReqVO acRepairReqVO) throws XpayChannelException {
        ACQueryPayReqVO acQueryPayReqVO = new ACQueryPayReqVO();
        this.queryPay(acQueryPayReqVO);
        return null;
    }
}