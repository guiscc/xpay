/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.msg.impl;

import com.xpay.channel.common.enums.EnumMsgType;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.AbsChannelMsgHandler;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @author qinshou
 * @version $Id: FormChannelMsgHandlerImpl.java, v 0.1 16/11/21 下午1:01 sxfans Exp $
 */
public class FormChannelMsgHandlerImpl<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO>
        extends AbsChannelMsgHandler<REQ, REP> {

    @Override
    public MsgReqModel builderMsg(REQ t, ChannelConfig channelConfig) throws BuildMsgException {
        MsgReqModel msgReqModel = new MsgReqModel();
        msgReqModel.setMsgType(EnumMsgType.FORM);
        msgReqModel.setMsgMap(t.getFormMap());
        return msgReqModel;
    }

    @Override
    public REP resolveMsg(REQ req, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return null;
    }
}