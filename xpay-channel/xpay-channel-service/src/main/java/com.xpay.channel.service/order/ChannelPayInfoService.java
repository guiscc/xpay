/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.order;

import com.xpay.channel.common.exception.XpayChannelException;
import com.xpay.channel.common.vo.agentcollect.ACPayRepVO;
import com.xpay.channel.common.vo.agentcollect.ACPayReqVO;
import com.xpay.channel.service.router.RouterContext;

/**
 * 渠道流水操作服务层
 * @author qinshou
 * @version $Id: ChannelPayInfoService.java, v 0.1 16/12/1 下午4:13 sxfans Exp $
 */
public interface ChannelPayInfoService {

    /**
     * 新增代收订单
     * @param context
     * @param acPayReqVO
     * @return
     */
    public ACPayRepVO add(RouterContext context, ACPayReqVO acPayReqVO) throws XpayChannelException;

    /**
     * 根据支付单号查询订单
     * @param payOrderNo
     * @return
     */
    public ACPayRepVO getByPayOrderNo(String payOrderNo);

    /**
     *
     * @param payOrderNo
     * @return
     */
    public int endPayInfo(ACPayRepVO payOrderNo);
}