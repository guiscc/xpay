/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.ChannelEntity;

import java.util.List;

/**
 * 通道持久化层
 * @author qinshou
 * @version $Id: ChannelEntity.java, v 0.1 16/11/30 上午11:27 sxfans Exp $
 */
public interface ChannelDao {

    /**
     * 根据支付工具子类型的银行找到相应的渠道
     * @param channelEntity
     * @return
     */
    public List<ChannelEntity> channelDao(ChannelEntity channelEntity);
}