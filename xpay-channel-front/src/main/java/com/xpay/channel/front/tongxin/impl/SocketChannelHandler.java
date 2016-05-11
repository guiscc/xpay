package com.xpay.channel.front.tongxin.impl;


import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * Socket通信类组件
 * Created by suxinxin on 14/12/25.
 */
public class SocketChannelHandler<REQ extends BaseReqDTO> extends AbsChannelTongXinHandler {
    @Override
    public byte[] send(BaseReqDTO req, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return new byte[0];
    }
}
