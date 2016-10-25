/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.channel.sms.taobao.msg;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.dto.BaseRepDTO;
import com.xpay.channel.front.dto.BaseReqDTO;
import com.xpay.channel.front.msg.AbsChannelMsgHandler;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * @author qinshou
 * @version $Id: TaoBao_SmsMsgHandler.java, v 0.1 16/10/24 下午8:12 sxfans Exp $
 */
public class TaoBao_SmsMsgHandler extends AbsChannelMsgHandler {
    @Override
    public byte[] builderMsg(BaseReqDTO t, ChannelConfig channelConfig) throws BuildMsgException {
        return super.builderMsg(t, channelConfig);
    }

    @Override
    public BaseRepDTO resolveMsg(BaseReqDTO baseReqDTO, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return super.resolveMsg(baseReqDTO, rtnMsg, channelConfig);
    }
}