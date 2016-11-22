/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.msg.impl;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.AbsChannelMsgHandler;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @author qinshou
 * @version $Id: JsonChannelMsgHandlerImpl.java, v 0.1 16/11/19 下午11:24 sxfans Exp $
 */
public class JsonChannelMsgHandlerImpl<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO>
        extends AbsChannelMsgHandler<REQ, REP> {

    @Override
    public MsgReqModel builderMsg(REQ t, ChannelConfig channelConfig) throws BuildMsgException {
        return null;
    }

    @Override
    public REP resolveMsg(REQ req, MsgRepModel rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return null;
    }
}