package com.xpay.channel.front.msg;

import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/17.
 */
public abstract class AbsChannelMsgHandler<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO>
                                                                                                     implements
                                                                                                     ChannelMsgHandler<REQ, REP> {

    @Override
    public REQ beforBuildMsg(REQ req, ChannelConfig channelConfig) throws BuildMsgException {
        return req;
    }

    @Override
    public MsgReqModel afterBuildMsg(REQ req, MsgReqModel msgReqModel, ChannelConfig channelConfig) throws BuildMsgException {
        return msgReqModel;
    }

    @Override
    public REQ beforResolveMsg(REQ req, ChannelConfig channelConfig) throws ResolveMsgException {
        return req;
    }

    @Override
    public REP afterResolveMsg(REQ req, REP rep, ChannelConfig channelConfig) throws ResolveMsgException {
        return rep;
    }
}
