package com.xpay.channel.front.msg;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/17.
 */
public abstract class AbsChannelMsgHandler<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO>
                                                                                           implements
                                                                                           ChannelMsgHandler<REQ, REP> {
    @Override
    public byte[] builderMsg(REQ t, ChannelConfig channelConfig) throws BuildMsgException {
        return new byte[0];
    }

    @Override
    public REP resolveMsg(REQ baseReqDTO, byte[] rtnMsg, ChannelConfig channelConfig)
                                                                                     throws ResolveMsgException {
        return null;
    }

    @Override
    public REQ beforBuildMsg(REQ baseReqDTO, ChannelConfig channelConfig) throws BuildMsgException {
        return baseReqDTO;
    }

    @Override
    public byte[] afterBuildMsg(REQ baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig)
                                                                                           throws BuildMsgException {
        return reqMsg;
    }

    @Override
    public byte[] beforResolveMsg(REQ baseReqDTO, byte[] repMsg, ChannelConfig channelConfig)
                                                                                             throws ResolveMsgException {
        return repMsg;
    }

    @Override
    public REP afterResolveMsg(REQ baseReqDTO, REP baseRepDTO, ChannelConfig channelConfig)
                                                                                           throws ResolveMsgException {
        return baseRepDTO;
    }
}
