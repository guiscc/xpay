package com.xpay.channel.front.msg;

import com.xpay.channel.common.dto.BaseRepDTO;
import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/17.
 */
public abstract class AbsChannelMsgHandler<REQ extends BaseReqDTO> implements ChannelMsgHandler {
    @Override
    public byte[] builderMsg(BaseReqDTO t, ChannelConfig channelConfig) throws BuildMsgException {
        return new byte[0];
    }

    @Override
    public BaseRepDTO resolveMsg(BaseReqDTO baseReqDTO, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return null;
    }

    @Override
    public BaseReqDTO beforBuildMsg(BaseReqDTO baseReqDTO, ChannelConfig channelConfig) throws BuildMsgException {
        return null;
    }

    @Override
    public byte[] afterBuildMsg(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws BuildMsgException {
        return new byte[0];
    }

    @Override
    public byte[] beforResolveMsg(BaseReqDTO baseReqDTO, byte[] repMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        return new byte[0];
    }

    @Override
    public BaseRepDTO afterResolveMsg(BaseReqDTO baseReqDTO, BaseRepDTO baseRepDTO, ChannelConfig channelConfig) throws ResolveMsgException {
        return null;
    }
}
