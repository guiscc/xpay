/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.biz.impl;

import com.xpay.channel.biz.AgentCollectBiz;
import com.xpay.channel.biz.convert.ACPayConvert;
import com.xpay.channel.biz.convert.ACQueryPayConvert;
import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.model.ChannelOrderModel;
import com.xpay.channel.common.vo.agentcollect.*;
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
@Component(value = "acBizChannelBiz")
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

        ChannelOrderModel channelOrderModel = channelPayInfoService.add(routerContext,acPayReqVO);

        //请求前置
        ACPayReqFrontDTO acPayReqFrontDTO = new ACPayReqFrontDTO();
        acPayReqFrontDTO = ACPayConvert.getACPayReqFrontDTO(acPayReqFrontDTO, acPayReqVO, channelOrderModel,routerContext);
        ACPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.pay(acPayReqFrontDTO);

        channelOrderModel = ACPayConvert.getACPayRepFrontDTO(channelOrderModel,acPayRepFrontDTO);

        //如果是最终状态修改数据库状态
        if(EnumPayStatus.isEnd(acPayRepFrontDTO.getPayStatus())) {
            channelPayInfoService.endPayInfo(channelOrderModel);
        }

        ACPayRepVO acPayRepVO = new ACPayRepVO();
        acPayRepVO.setChannelOrderModel(channelOrderModel);
        return acPayRepVO;
    }

    @Override
    public ACQueryPayRepVO queryPay(ACQueryPayReqVO acQueryPayReqVO) throws XpayChannelException {

        ACQueryPayRepVO acQueryPayRepVO = new ACQueryPayRepVO();

        //查单
        ChannelOrderModel channelOrderModel = channelPayInfoService.getByPayOrderNo(acQueryPayReqVO.getPayOrderNo());
        acQueryPayRepVO.setChannelOrderModel(channelOrderModel);
        if(channelOrderModel == null){
            return acQueryPayRepVO;
        }

        //如果不支持补单则
        if(!acQueryPayReqVO.getRepair()) {
            return acQueryPayRepVO;
        }

        //根据配置处理中的订单是否请求前置
        ACQueryPayReqFrontDTO acQueryPayReqFrontDTO = new ACQueryPayReqFrontDTO();
        acQueryPayReqFrontDTO = ACQueryPayConvert.getACQueryPayReqFrontDTO(acQueryPayReqFrontDTO, acQueryPayRepVO);
        ACQueryPayRepFrontDTO acPayRepFrontDTO = agentCollectFrontFacade.payQuery(acQueryPayReqFrontDTO);
        channelOrderModel = ACQueryPayConvert.getACQueryPayRepVO(channelOrderModel, acPayRepFrontDTO);

        //如果是最终状态修改数据库状态
        if(EnumPayStatus.isEnd(acPayRepFrontDTO.getPayStatus())) {
            channelPayInfoService.endPayInfo(channelOrderModel);
        }

        acQueryPayRepVO.setChannelOrderModel(channelOrderModel);
        return acQueryPayRepVO;
    }
}