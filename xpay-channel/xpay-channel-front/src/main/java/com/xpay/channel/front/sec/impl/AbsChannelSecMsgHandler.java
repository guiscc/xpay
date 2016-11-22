/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.sec.impl;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.sec.ChannelSecMsgHandler;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @author qinshou
 * @version $Id: AbsChannelSecMsgHandler.java, v 0.1 16/11/22 上午1:46 sxfans Exp $
 */
public abstract class AbsChannelSecMsgHandler implements ChannelSecMsgHandler {
    @Override
    public byte[] digest(BaseReqFrontDTO req, ChannelConfig channelConfig) {
        return new byte[0];
    }

    @Override
    public boolean verifyDigest(MsgRepModel req, ChannelConfig channelConfig) {
        return false;
    }

    @Override
    public BaseReqFrontDTO encrypt(BaseReqFrontDTO req, ChannelConfig channelConfig) throws BuildMsgException {
        return null;
    }

    @Override
    public byte[] decrypt(BaseReqFrontDTO req, ChannelConfig channelConfig) {
        return new byte[0];
    }
}