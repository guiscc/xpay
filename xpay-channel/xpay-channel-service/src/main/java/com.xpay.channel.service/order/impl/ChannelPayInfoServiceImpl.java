/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.order.impl;

import com.xpay.channel.common.vo.agentcollect.ACPayReqVO;
import com.xpay.channel.dao.entity.PayInfoEntity;
import com.xpay.channel.service.order.ChannelPayInfoService;
import com.xpay.channel.service.router.RouterContext;
import org.springframework.stereotype.Service;

/**
 * @author qinshou
 * @version $Id: ChannelPayInfoServiceImpl.java, v 0.1 16/12/1 下午4:29 sxfans Exp $
 */
@Service
public class ChannelPayInfoServiceImpl implements ChannelPayInfoService{

    @Override
    public PayInfoEntity add(RouterContext context, ACPayReqVO acPayReqVO) {
        return null;
    }

    @Override
    public PayInfoEntity getByPayOrderNo(String payOrderNo) {

        return null;
    }
}