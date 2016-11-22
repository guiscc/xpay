package com.xpay.channel.front.tongxin;

import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.msg.model.MsgRepModel;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/16.
 */
public abstract class AbsChannelTongXinHandler<REQ extends BaseReqFrontDTO>
                                                                       implements
                                                                       ChannelTongXinHandler<REQ> {

    @Override
    public MsgReqModel sendBefor(REQ req, MsgReqModel msgReqModel, ChannelConfig channelConfig) throws CommuException {
        return msgReqModel;
    }

    @Override
    public MsgRepModel sendAfter(REQ req, MsgRepModel reqMsg, ChannelConfig channelConfig) throws CommuException {
        return reqMsg;
    }
}
