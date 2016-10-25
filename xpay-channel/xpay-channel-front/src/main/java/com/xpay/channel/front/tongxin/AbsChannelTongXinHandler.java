package com.xpay.channel.front.tongxin;

import com.xpay.channel.front.dto.BaseReqDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Created by suxinxin on 16/2/16.
 */
public abstract class AbsChannelTongXinHandler<REQ extends BaseReqDTO>
                                                                       implements
                                                                       ChannelTongXinHandler<REQ> {
    @Override
    public byte[] send(REQ baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig)
                                                                                         throws CommuException {
        return new byte[0];
    }

    @Override
    public byte[] sendBefor(REQ baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig)
                                                                                              throws CommuException {
        return new byte[0];
    }

    @Override
    public byte[] sendAfter(REQ baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig)
                                                                                              throws CommuException {
        return new byte[0];
    }
}
