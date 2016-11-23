/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.facade.impl;

import com.xpay.channel.common.exception.*;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthRepFrontDTO;
import com.xpay.channel.front.dto.agentcollect.RealNameAuthReqFrontDTO;
import com.xpay.channel.front.executor.AbsFrontExecutor;
import com.xpay.channel.front.facade.CustomerFrontFacade;
import com.xpay.channel.front.factory.MappingFactory;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: CustomerFrontFacadeImpl.java, v 0.1 16/11/23 下午10:45 sxfans Exp $
 */
public class CustomerFrontFacadeImpl implements CustomerFrontFacade {

    @Resource
    private MappingFactory mappingFactory;

    @Override
    public RealNameAuthRepFrontDTO auth(RealNameAuthReqFrontDTO reqDto) throws FrontException {
        try {
            AbsFrontExecutor<RealNameAuthReqFrontDTO, RealNameAuthRepFrontDTO> absFrontExecutor = mappingFactory
                .getChannelBean(reqDto.getChannelCode());
            RealNameAuthRepFrontDTO realNameAuthRepFrontDTO = absFrontExecutor.doProcess(reqDto);
            return realNameAuthRepFrontDTO;
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
}