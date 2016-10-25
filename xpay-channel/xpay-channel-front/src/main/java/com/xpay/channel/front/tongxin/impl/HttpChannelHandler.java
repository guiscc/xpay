package com.xpay.channel.front.tongxin.impl;

import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.dto.BaseReqDTO;
import com.xpay.channel.front.tongxin.AbsChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http通信类组件
 * Created by suxinxin on 14/12/25.
 */
public class HttpChannelHandler<REQ extends BaseReqDTO> extends AbsChannelTongXinHandler<BaseReqDTO> {

    private static final Logger logger = LoggerFactory.getLogger(HttpChannelHandler.class);

    @Override
    public byte[] send(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.send(baseReqDTO, reqMsg, channelConfig);
    }

    @Override
    public byte[] sendBefor(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.sendBefor(baseReqDTO, reqMsg, channelConfig);
    }

    @Override
    public byte[] sendAfter(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.sendAfter(baseReqDTO, reqMsg, channelConfig);
    }
}
