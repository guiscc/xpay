/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.facade.impl;

import com.xpay.channel.common.exception.*;
import com.xpay.channel.front.dto.sms.SmsRepFrontDTO;
import com.xpay.channel.front.dto.sms.SmsReqFrontDTO;
import com.xpay.channel.front.executor.AbsFrontExecutor;
import com.xpay.channel.front.facade.SmsFrontFacade;
import com.xpay.channel.front.factory.MappingFactory;

import javax.annotation.Resource;

/**
 * @author qinshou
 * @version $Id: SmsFrontFacadeImpl.java, v 0.1 16/10/24 下午5:12 sxfans Exp $
 */
public class SmsFrontFacadeImpl implements SmsFrontFacade {

    @Resource
    private MappingFactory mappingFactory;

    @Override
    public SmsRepFrontDTO sendSMS(SmsReqFrontDTO smsReqDTO) throws FrontException {
        try {
            AbsFrontExecutor<SmsReqFrontDTO, SmsRepFrontDTO> absFrontExecutor = mappingFactory
                .getChannelBean(smsReqDTO.getChannelCode());
            SmsRepFrontDTO smsRepDTO = absFrontExecutor.doProcess(smsReqDTO);
            return smsRepDTO;
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

    /**
     * Getter method for property mappingFactory.
     *
     * @return property value of mappingFactory
     **/
    public MappingFactory getMappingFactory() {
        return mappingFactory;
    }

    /**
     * Setter method for property mappingFactory.
     *
     * @param mappingFactory value to be assigned to property mappingFactory
     **/
    public void setMappingFactory(MappingFactory mappingFactory) {
        this.mappingFactory = mappingFactory;
    }

}