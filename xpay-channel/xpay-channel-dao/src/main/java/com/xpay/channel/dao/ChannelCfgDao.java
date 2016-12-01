/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao;

import com.xpay.channel.dao.entity.ChannelCfgEntity;

/**
 * 通道配置
 * @author qinshou
 * @version $Id: ChannelCfgDao.java, v 0.1 16/12/1 上午10:07 sxfans Exp $
 */
public interface ChannelCfgDao {

    /**
     * 根据通道编码获取通道配置
     * @param channelCode
     * @return
     */
    public ChannelCfgEntity get(String channelCode);
}