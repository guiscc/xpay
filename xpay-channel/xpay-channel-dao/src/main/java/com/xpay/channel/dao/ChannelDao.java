/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.ChannelEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通道持久化层
 * @author qinshou
 * @version $Id: ChannelEntity.java, v 0.1 16/11/30 上午11:27 sxfans Exp $
 */
@Repository
public interface ChannelDao {

    /**
     * 根据支付工具子类型的银行找到相应的渠道
     * @param channelCodes 渠道编码集合
     * @return
     */
    public List<ChannelEntity> findByChannelCode(String channelCodes);

    /**
     * 根据渠道编码查询单个渠道信息
     * @param channelCode
     * @return
     */
    public ChannelEntity get(String channelCode);
}