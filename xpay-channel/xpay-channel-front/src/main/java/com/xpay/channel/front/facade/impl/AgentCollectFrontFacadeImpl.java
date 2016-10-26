package com.xpay.channel.front.facade.impl;


import com.xpay.channel.front.dto.agentcollect.*;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;

/**
 * 此类通过模版模式，抽象实现quickPayChannel接口，
 * 并且通过注入的方式将组件注入到类中，方便业务实现类组件核心接口调用
 */
public class AgentCollectFrontFacadeImpl implements AgentCollectFrontFacade {

    @Override
    public ACPayRepFrontFrontDTO pay(ACPayReqFrontFrontDTO reqDto) {
        return null;
    }

    @Override
    public ACQueryPayRepFrontFrontDTO payQuery(ACQueryPayReqFrontFrontDTO reqDto) {
        return null;
    }

    @Override
    public RefundRepFrontFrontDTO refund(RefundReqFrontFrontDTO reqDto) {
        return null;
    }

    @Override
    public CancelRepFrontFrontDTO cancel(CancelReqFrontFrontDTO reqDto) {
        return null;
    }

    @Override
    public PayCallbackRepFrontFrontDTO payCallback(PayCallbackReqFrontFrontDTO reqDto) {
        return null;
    }

    @Override
    public RefundCallbackRepFrontFrontDTO refundCallback(RefundCallbackReqFrontFrontDTO reqDto) {
        return null;
    }

    @Override
    public CancelCallbackRepFrontFrontDTO cancelCallback(CancelCallbackReqFrontFrontDTO reqDto) {
        return null;
    }
}
