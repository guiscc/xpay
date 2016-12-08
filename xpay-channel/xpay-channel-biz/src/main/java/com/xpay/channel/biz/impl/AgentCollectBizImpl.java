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
import com.xpay.channel.dao.entity.PayInfoEntity;
import com.xpay.channel.front.dto.agentcollect.ACPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACPayReqFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.ACQueryPayReqFrontDTO;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import com.xpay.channel.service.order.ChannelPayInfoService;
import com.xpay.channel.service.router.ChannelRouter;
import com.xpay.channel.service.router.RouterContext;
import com.xpay.channel.service.router.RouterParam;
import com.xpay.common.enums.EnumPayStatus;
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

    @Resource(name = "acPayRouter")
    private ChannelRouter payChannelRouter;

    @Resource(name = "acPayRouter")
    private ChannelRouter payQuerychannelRouter;

    @Resource
    private ChannelPayInfoService channelPayInfoService;

    @Override
    public ACPayRepVO pay(ACPayReqVO acPayReqVO) throws XpayChannelException {

        //路由
        RouterParam routerParam = new RouterParam();
        routerParam.setPayAmt(acPayReqVO.getPayAmt());
        routerParam.setCardType(acPayReqVO.getCardType());
        routerParam.setInstCode(acPayReqVO.getInstCode());
        routerParam.setPayTools(acPayReqVO.getPayTool());
        routerParam.setPaySubTools(acPayReqVO.getPaySubTool());
        RouterContext routerContext = payChannelRouter.router(routerParam);

        ACPayRepVO acPayRepVO = channelPayInfoService.add(routerContext,acPayReqVO);

        //请求前置
        ACPayReqFrontDTO acPayReqFrontDTO = new ACPayReqFrontDTO();
        acPayReqFrontDTO = ACPayConvert.getACPayReqFrontDTO(acPayReqFrontDTO, acPayReqVO);
        acPayReqFrontDTO.setChannelCode(routerContext.getChannelEntity().getChannelCode());
        acPayReqFrontDTO.setMerchantNo(routerContext.getInstMerchantEntity().getMerchantNo());
        ACPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.pay(acPayReqFrontDTO);
        acPayRepVO = ACPayConvert.getACPayRepFrontDTO(acPayRepVO,acPayRepFrontDTO);

        //如果是最终状态修改数据库状态
        if(EnumPayStatus.isEnd(acPayRepFrontDTO.getPayStatus())) {
            channelPayInfoService.endPayInfo(acPayRepVO);
        }

        return acPayRepVO;
    }

    @Override
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayChannelException {

        ACQueryPayRepVO acQueryPayRepVO = new ACQueryPayRepVO();

        //查单
        ACPayRepVO acPayRepVO = channelPayInfoService.getByPayOrderNo(acQueryPayReqVO.getPayOrderNo());
        if(acPayRepVO == null){
            return acQueryPayRepVO;
        }

        //如果不支持补单则
        if(!acQueryPayReqVO.getRepair()) {
            acQueryPayRepVO.setPayOrderModel(acPayRepVO.getPayOrderModel());
            return acQueryPayRepVO;
        }

        //根据配置处理中的订单是否请求前置
        ACQueryPayReqFrontDTO acQueryPayReqFrontDTO = new ACQueryPayReqFrontDTO();
        acQueryPayReqFrontDTO = ACQueryPayConvert.getACQueryPayReqFrontDTO(acQueryPayReqFrontDTO, acQueryPayReqVO);
        ACQueryPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.payQuery(acQueryPayReqFrontDTO);
        acQueryPayRepVO = ACQueryPayConvert.getACQueryPayRepVO(acQueryPayRepVO,acPayRepFrontDTO);

        //如果是最终状态修改数据库状态
        if(EnumPayStatus.isEnd(acPayRepFrontDTO.getPayStatus())) {
            channelPayInfoService.endPayInfo(acPayRepVO);
        }
        return acQueryPayRepVO;
    }
}