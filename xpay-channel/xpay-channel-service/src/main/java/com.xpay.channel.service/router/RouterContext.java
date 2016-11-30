/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;


import com.xpay.channel.dao.entity.*;

import java.util.List;

/**
 * @author qinshou
 * @version $Id: RouterContext.java, v 0.1 16/11/25 下午4:47 sxfans Exp $
 */
public class RouterContext {

    /**
     * 通道实体
     */
    private PayToolsEntity payToolsEntity;

    /**
     * 接口实体
     */
    private ChannelEntity channelEntity;

    /**
     * 接口配置
     */
    private ChannelCfgEntity channelCfgEntity;

    /**
     * 所属机构
     */
    private InstitutionEntity institutionEntity;

    /**
     * 机构商户
     */
    private InstMerchantEntity instMerchantEntity;

    /**
     * 服务商映射
     */
    private PayToolsMappingEntity instInterfaceEntity;

    /**
     * 通道下所有支持的接口
     */
    private List<ChannelEntity> channelInterfaceEntities;

//    /**
//     * 订单生成器
//     */
//    private SequenceService   sequenceService;
//
//    /**
//     * 订单生成器
//     */
//    private SequenceService   refundSequenceService;
}