package com.xpay.channel.front.tongxin;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/16.
 */
public abstract class AbsChannelTongXinHandler<REQ extends BaseReqDTO> implements ChannelTongXinHandler {
    @Override
    public byte[] send(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig)
            throws CommuException {
        return reqMsg;
    }

    @Override
    public byte[] sendBefor(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return reqMsg;
    }

    @Override
    public byte[] sendAfter(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return reqMsg;
    }
}
