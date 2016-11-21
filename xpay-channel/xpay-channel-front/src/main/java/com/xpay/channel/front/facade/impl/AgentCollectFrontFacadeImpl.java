package com.xpay.channel.front.facade.impl;

import com.xpay.channel.common.exception.*;
import com.xpay.channel.front.dto.agentcollect.*;
import com.xpay.channel.front.executor.AbsFrontExecutor;
import com.xpay.channel.front.facade.AgentCollectFrontFacade;
import com.xpay.channel.front.factory.MappingFactory;

import javax.annotation.Resource;

/**
 * 此类通过模版模式，抽象实现quickPayChannel接口，
 * 并且通过注入的方式将组件注入到类中，方便业务实现类组件核心接口调用
 */
public class AgentCollectFrontFacadeImpl implements AgentCollectFrontFacade {

    @Resource
    private MappingFactory mappingFactory;

    @Override
    public ACPayRepFrontDTO pay(ACPayReqFrontDTO reqDto) throws FrontException {

        try {
            AbsFrontExecutor<ACPayReqFrontDTO, ACPayRepFrontDTO> absFrontExecutor = mappingFactory
                .getChannelBean(reqDto.getChannelCode());
            return absFrontExecutor.doProcess(reqDto);
        } catch (VldException e) {
            throw new FrontException(e.getRtnResult());
        } catch (ResolveMsgException e) {
            throw new FrontException(e.getRtnResult());
        } catch (BuildMsgException e) {
            throw new FrontException(e.getRtnResult());
        } catch (CommuException e) {
            throw new FrontException(e.getRtnResult());
        }
    }

    @Override
    public ACQueryPayRepFrontDTO payQuery(ACQueryPayReqFrontDTO reqDto) throws FrontException {
        try {
            AbsFrontExecutor<ACQueryPayReqFrontDTO, ACQueryPayRepFrontDTO> absFrontExecutor = mappingFactory
                .getChannelBean(reqDto.getChannelCode());
            return absFrontExecutor.doProcess(reqDto);
        } catch (VldException e) {
            throw new FrontException(e.getRtnResult());
        } catch (ResolveMsgException e) {
            throw new FrontException(e.getRtnResult());
        } catch (BuildMsgException e) {
            throw new FrontException(e.getRtnResult());
        } catch (CommuException e) {
            throw new FrontException(e.getRtnResult());
        }
    }

    @Override
    public RefundRepFrontDTO refund(RefundReqFrontDTO reqDto) {
        return null;
    }

    @Override
    public CancelRepFrontDTO cancel(CancelReqFrontDTO reqDto) {
        return null;
    }

    @Override
    public PayCallbackRepFrontDTO payCallback(PayCallbackReqFrontDTO reqDto) {
        return null;
    }

    @Override
    public RefundCallbackRepFrontDTO refundCallback(RefundCallbackReqFrontDTO reqDto) {
        return null;
    }

    @Override
    public CancelCallbackRepFrontDTO cancelCallback(CancelCallbackReqFrontDTO reqDto) {
        return null;
    }
}
