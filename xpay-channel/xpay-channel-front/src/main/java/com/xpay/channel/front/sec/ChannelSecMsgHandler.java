/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.sec;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @author qinshou
 * @version $Id: ChannelSecMsgHandler.java, v 0.1 16/11/22 上午1:11 sxfans Exp $
 */
public interface ChannelSecMsgHandler{

    /**
     * 签名
     * @param req
     * @param channelConfig
     * @return
     */
    public byte[] digest(BaseReqFrontDTO req, ChannelConfig channelConfig);

    //###############################

    /**
     * 验证签名
     *
     * @param req
     * @param channelConfig
     * @return
     */
    public boolean verifyDigest(MsgRepModel req, ChannelConfig channelConfig);

    //###############################

    /**
     * 加密
     * @param req
     * @param channelConfig
     */
    public BaseReqFrontDTO encrypt(BaseReqFrontDTO req, ChannelConfig channelConfig) throws BuildMsgException;


    //###################################
    /**
     * 解密
     * @param req
     * @param channelConfig
     */
    public byte[] decrypt(BaseReqFrontDTO req, ChannelConfig channelConfig);
}